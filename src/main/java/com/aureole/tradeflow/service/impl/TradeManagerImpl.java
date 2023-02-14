package com.aureole.tradeflow.service.impl;

import com.aureole.tradeflow.model.payloads.Trade;
import com.aureole.tradeflow.model.trade.TradeEntity;
import com.aureole.tradeflow.model.trade.TradeFactory;
import com.aureole.tradeflow.model.trade.TradeType;
import com.aureole.tradeflow.repository.TradeRepository;
import com.aureole.tradeflow.service.ITradeManager;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class TradeManagerImpl implements ITradeManager {
    
    @Autowired
    private TradeRepository tradeRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    @Async
    public void manyInsert(TradeType tradeType) {
        TradeEntity tradeEntity = TradeFactory.getTradeEntityType(tradeType);
        Duration duration = Duration.ZERO;

        for (int i = 0; i < tradeType.getCount(); i++) {
            Trade tradeToBeInserted = tradeEntity.getTrade(i);
            Instant instantStart = Instant.now();
            tradeRepository.insert(tradeToBeInserted);
            Instant instantEnd = Instant.now();
            duration = duration.plus(Duration.between(instantStart, instantEnd));
        }
        log.trace("Time in Seconds took to insert all the records:" + duration.getSeconds());
        log.trace("Time in MilliSeconds took to insert all the records:" + duration.toMillis());
        log.trace("Total Trades Inserted in Bulk:" + tradeType.getCount());
    }

    public Trade save(Trade trade) {
        return tradeRepository.save(trade);
    }

    @Async
    public void findAllUsingCursor(int totalRecordCount, int batchSize) {

        Duration duration = Duration.ZERO;

        for (int i = 0; i < totalRecordCount / batchSize; i++) {
            final Pageable pageableRequest = PageRequest.of(i, batchSize);
            Query getAllQuery = new Query();
            getAllQuery.with(pageableRequest);
            Instant instantStart = Instant.now();
            mongoTemplate.find(getAllQuery, Trade.class);
            Instant instantEnd = Instant.now();
            duration = duration.plus(Duration.between(instantStart, instantEnd));
        }
        log.trace("Time in Seconds took to fetch all the records: " + duration.getSeconds());
        log.trace("Time in MilliSeconds took to fetch all the records: " + duration.toMillis());
    }

    @Async
    public void findAll() {
        Instant instantStart = Instant.now();
        List<Trade> listOfTrades = tradeRepository.findAll();
        Instant instantEnd = Instant.now();

        Duration duration = Duration.between(instantStart, instantEnd);
        log.trace("Time in Seconds took to fetch all the records" + duration.getSeconds());
        log.trace("Time in MilliSeconds took to fetch all the records" + duration.toMillis());
        log.trace("Size of all trades Retrieved:" + listOfTrades.size());

    }

    public Page<Trade> findAllWithPaginationAndSorting(Pageable pageable) {
        log.trace(pageable);
        return tradeRepository.findAll(pageable);
    }


    public Optional<Trade> getADocumentById(String id) {
        return tradeRepository.findById(id);
    }


    public long findCount() {
        return tradeRepository.count();
    }

    @Override
    public List<Trade> searchByExternalRefNumber(Integer externalRefNumber) {
        return tradeRepository.searchByExternalRefNumber(externalRefNumber);
    }

    @Override
    public List<Trade> searchByContractId(Integer contractId) {
        return tradeRepository.searchByContractId(contractId);
    }

    @Override
    public List<Trade> searchByGlobalKey(String globalKey) {
        return tradeRepository.searchByGlobalKey(globalKey);
    }


}
