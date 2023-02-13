package com.aureole.tradeflow.service.impl;

import com.aureole.tradeflow.model.payloads.Trade;
import com.aureole.tradeflow.repository.TradeRepository;
import com.aureole.tradeflow.service.ITradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * NOT IN USE for BULK Inserts.
 */
@Service
public class TradeServiceImpl implements ITradeService {

    @Autowired
    private TradeRepository tradeRepository;

    public Trade save(Trade trade) {
        return tradeRepository.save(trade);
    }

    public List<Trade> findAll(){
        return tradeRepository.findAll();
    }


    public Optional<Trade> getADocumentById( String  id){
        return tradeRepository.findById(id);
    }


    public long findCount(){
        return tradeRepository.count();
    }

}
