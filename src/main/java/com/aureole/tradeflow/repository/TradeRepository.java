package com.aureole.tradeflow.repository;


import com.aureole.tradeflow.model.payloads.Trade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends MongoRepository<Trade, String> {

    long count();

    // Depth 1 record
    @Query(value = "{'externalRefNumber' : ?0}")
    List<Trade> searchByExternalRefNumber(Integer externalRefNumber);

    // Depth 2 record
    @Query(value = "{'contractDetails.contractId' : ?0}")
    List<Trade> searchByContractId(Integer contractId);

    // Depth 4th Record
    @Query(value = "{'contractDetails.description.meta.globalKey': ?0}")
    List<Trade> searchByGlobalKey(String globalKey);


}