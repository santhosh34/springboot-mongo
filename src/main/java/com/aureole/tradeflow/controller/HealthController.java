package com.aureole.tradeflow.controller;

import com.aureole.tradeflow.constants.HealthEnum;
import com.aureole.tradeflow.model.availability.Health;
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
@RequestMapping("/health")
public class HealthController {

    @GetMapping(path = "/health")
    public ResponseEntity<Health> getHealth(){
        return  ResponseEntity.status(200).body(HealthEnum.HEALTHY.getHealthStatus());
    }
}
