package com.aureole.tradeflow.service.impl;

import com.aureole.tradeflow.constants.TradeSizeEnum;
import com.aureole.tradeflow.model.payloads.Trade;
import com.aureole.tradeflow.model.trade.MiniTrade;
import com.aureole.tradeflow.model.trade.TradeEntity;
import com.aureole.tradeflow.model.trade.TradeFactory;
import com.aureole.tradeflow.model.trade.TradeType;
import com.aureole.tradeflow.repository.TradeRepository;
import com.aureole.tradeflow.service.ITradeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TradeManagerImpl implements ITradeManager {

    @Autowired
    private TradeRepository tradeRepository;


    @Override
    public void manyInsert(TradeType tradeType) {
        TradeEntity tradeEntity = TradeFactory.getTradeEntityType(tradeType);
        Duration duration= Duration.ZERO;

        for (int i = 0; i < tradeType.getCount(); i++) {
            Trade tradeToBeInserted = tradeEntity.getTrade(i);
            Instant instantStart= Instant.now();
            tradeRepository.insert(tradeToBeInserted);
            Instant instantEnd= Instant.now();
            duration= duration.plus (Duration.between(instantStart, instantEnd));
        }
        System.out.println("duration in seconds:"+duration.getSeconds());
        System.out.println("duration in millis:"+duration.toMillis());
        System.out.println("completed  times "+tradeType.getCount());
    }

    public Trade save(Trade trade) {
        return tradeRepository.save(trade);
    }

    public List<Trade> findAll(){
        return tradeRepository.findAll();
    }

    public Page<Trade> findAllWithPaginationAndSorting(Pageable pageable){
        return tradeRepository.findAll(pageable);
    }


    public Optional<Trade> getADocumentById(String  id){
        return tradeRepository.findById(id);
    }


    public long findCount(){
        return tradeRepository.count();
    }

    @Override
    public List<Trade> searchTradesWithGlobalKey(String globalKey) {
        return tradeRepository.searchHereThereTradesWithGlobalKey(globalKey);
    }


    @Override
    public List<Trade> searchHereThereByExternalRefNumber(Integer externalRefNumber) {
        return tradeRepository.searchHereThereByExternalRefNumber(externalRefNumber);
    }


}
