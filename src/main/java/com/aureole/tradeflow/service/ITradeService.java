package com.aureole.tradeflow.service;

import com.aureole.tradeflow.model.payloads.Trade;

import java.util.List;
import java.util.Optional;

public interface ITradeService {

     Trade save(Trade trade);

     List<Trade> findAll();

     Optional<Trade> getADocumentById(String  id);

     long findCount();

}
