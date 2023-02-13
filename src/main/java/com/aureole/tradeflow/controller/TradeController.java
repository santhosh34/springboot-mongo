package com.aureole.tradeflow.controller;


import com.aureole.tradeflow.model.trade.TradeType;
import com.aureole.tradeflow.model.availability.Health;
import com.aureole.tradeflow.constants.HealthEnum;
import com.aureole.tradeflow.model.payloads.Trade;
import com.aureole.tradeflow.service.ITradeManager;
import com.aureole.tradeflow.service.ITradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trades")
public class TradeController {
    @Autowired
    private  ITradeService tradeService;

    @Autowired
    private ITradeManager tradeManager;

    @GetMapping(path = "/health")
    public ResponseEntity<Health> getHealth(){
        return  ResponseEntity.status(200).body(HealthEnum.HEALTHY.getHealthStatus());
    }

    @PostMapping(path="/bulk")
    public ResponseEntity  bulkInsertRecords(@RequestBody TradeType tradeType){

        tradeManager.bulkInsert(tradeType);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public Trade  saveTrade(@RequestBody Trade trade){
        return tradeService.save(trade);
    }

    @GetMapping
    public List<Trade> findAll(){
        return tradeService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Trade> getADocumentById(@PathVariable String  id){
        return tradeService.getADocumentById(id);
    }

    @GetMapping(path = "/count")
    public long findCount(){
        return tradeService.findCount();
    }

}
