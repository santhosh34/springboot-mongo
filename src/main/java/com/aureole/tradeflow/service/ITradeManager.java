package com.aureole.tradeflow.service;

import com.aureole.tradeflow.model.payloads.Trade;
import com.aureole.tradeflow.model.trade.TradeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ITradeManager  {

    Trade save(Trade trade);

    void manyInsert(TradeType tradeType);

    List<Trade> findAll();


    Page<Trade> findAllWithPaginationAndSorting(Pageable pageable);

    Optional<Trade> getADocumentById(String  id);

    long findCount();

    List<Trade> searchTradesWithGlobalKey(String globalKey);

    List<Trade>  searchHereThereByExternalRefNumber(Integer externalRefNumber);


}
