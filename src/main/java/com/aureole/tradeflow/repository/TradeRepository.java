package com.aureole.tradeflow.repository;


import com.aureole.tradeflow.model.payloads.Trade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends MongoRepository<Trade, String> {

    public long count();

    @Query(value= "{'externalRefNumber' : ?0}")
    List<Trade> searchHereThereByExternalRefNumber(Integer externalRefNumber);


    @Query(value= "{'externalRefNumber.contractId' : ?0}")
    List<Trade> searchHereThereTradesWithGlobalKey(String globalKey);


}