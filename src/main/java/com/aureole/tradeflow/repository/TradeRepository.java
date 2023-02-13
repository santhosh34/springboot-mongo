package com.aureole.tradeflow.repository;


import com.aureole.tradeflow.model.payloads.Trade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends MongoRepository<Trade, String> {

//    @Query("{id:'?0'}")
//    Trade findItemById(String id);
//
//    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
//    List<Trade> findAll(String category);

    public long count();

}