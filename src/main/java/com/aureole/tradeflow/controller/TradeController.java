package com.aureole.tradeflow.controller;

import com.aureole.tradeflow.model.payloads.Trade;
import com.aureole.tradeflow.model.trade.TradeType;
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

    @PostMapping
    public Trade saveTrade(@RequestBody Trade trade) {
        return tradeManager.save(trade);
    }

    @PostMapping(path = "/triggers/insert-many")
    public ResponseEntity insertManyRecords(@RequestBody TradeType tradeType) {
        tradeManager.manyInsert(tradeType);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/all")
    public ResponseEntity findAll() {
        tradeManager.findAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/calc-time-to-fetch-all-recursively")
    public ResponseEntity findAllRecursively(@RequestParam int totalRecordCount, @RequestParam int batchSize) {
        tradeManager.findAllUsingCursor(totalRecordCount, batchSize);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public Page<Trade> findPaginatedResults(Pageable pageable) {
        return tradeManager.findAllWithPaginationAndSorting(pageable);
    }

    @GetMapping(path = "/{id}")
    public Optional<Trade> getADocumentById(@PathVariable String id) {
        return tradeManager.getADocumentById(id);
    }

    @GetMapping(path = "/search-at/depth1/{externalRefNumber}")
    public List<Trade> searchDocsWith1stLevelJsonValue(@PathVariable Integer externalRefNumber) {
        return tradeManager.searchByExternalRefNumber(externalRefNumber);
    }

    @GetMapping(path = "/search-at/depth2/{contractId}")
    public List<Trade> searchDocsWith2ndLevelJsonValue(@PathVariable Integer contractId) {
        return tradeManager.searchByContractId(contractId);
    }

    @GetMapping(path = "/search-at/depth4/{globalKey}")
    public List<Trade> searchDocsWith4thLevelJsonValue(@PathVariable String globalKey, Pageable pageable) {
        return tradeManager.searchByGlobalKey(globalKey);
    }


    @GetMapping(path = "/count")
    public long findCount() {
        return tradeManager.findCount();
    }

}
