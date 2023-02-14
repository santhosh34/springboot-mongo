package com.aureole.tradeflow.localtest;

import com.aureole.tradeflow.constants.HealthEnum;
import com.aureole.tradeflow.model.payloads.Trade;
import com.aureole.tradeflow.model.trade.MiniTrade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LocalTest {

    public static void main(String[] args) {
        LocalTest localTest = new LocalTest();
       localTest.printBatchNumber(10,29);
    }

    public int printBatchNumber( int batchSize, int currentIndex){

        int batchNumber= (currentIndex/ batchSize) + 1;
        return batchNumber;
    }

    public void saveTrade() {
        Trade trade = new MiniTrade().getTrade(1);
        log.trace(getTradeJson(trade));
    }

    public void testEnum() {
        log.trace(HealthEnum.HEALTHY.getHealthStatus());
    }

    public String  getTradeJson(Trade trade ) {
        ObjectMapper mapper = new ObjectMapper();
        try {
           return mapper.writeValueAsString(trade);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
