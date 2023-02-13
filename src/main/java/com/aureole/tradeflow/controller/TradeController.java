package com.aureole.tradeflow.controller;

import com.aureole.tradeflow.model.trade.TradeType;
import com.aureole.tradeflow.model.availability.Health;
import com.aureole.tradeflow.constants.HealthEnum;
import com.aureole.tradeflow.model.payloads.Trade;
import com.aureole.tradeflow.service.ITradeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trades")
public class TradeController {
    @Autowired
    private ITradeManager tradeManager;

    @GetMapping(path = "/health")
    public ResponseEntity<Health> getHealth(){
        return  ResponseEntity.status(200).body(HealthEnum.HEALTHY.getHealthStatus());
    }

    @PostMapping
    public Trade  saveTrade(@RequestBody Trade trade){
        return tradeManager.save(trade);
    }

    @PostMapping(path="/insert-many")
    public ResponseEntity  manyInsertRecords(@RequestBody TradeType tradeType){

        tradeManager.manyInsert(tradeType);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path= "")
    public List<Trade> findAll(){
        return tradeManager.findAll();
    }

    @GetMapping(path= "/paginated")
    public Page<Trade> findPaginatedResults(Pageable pageable){
        return tradeManager.findAllWithPaginationAndSorting(pageable);
    }

    @GetMapping(path = "/{id}")
    public Optional<Trade> getADocumentById(@PathVariable String  id){
        return tradeManager.getADocumentById(id);
    }

    @GetMapping(path = "/filter/{globalKey}")
    public List<Trade> searchDocsWith2ndLevelJsonValue(@PathVariable String  globalKey){
        return tradeManager.searchTradesWithGlobalKey(globalKey);
    }

    @GetMapping(path = "/filterByRef/{externalRefNumber}")
    public List<Trade> searchDocsWith2ndLevelJsonValue(@PathVariable Integer  externalRefNumber){
        return tradeManager.searchHereThereByExternalRefNumber(externalRefNumber);
    }

    @GetMapping(path = "/count")
    public long findCount(){
        return tradeManager.findCount();
    }

}
