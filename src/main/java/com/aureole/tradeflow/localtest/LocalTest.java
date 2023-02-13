package com.aureole.tradeflow.localtest;

import com.aureole.tradeflow.constants.HealthEnum;
import com.aureole.tradeflow.model.payloads.Trade;
import com.aureole.tradeflow.model.trade.MiniTrade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocalTest {

    public static void main(String[] args) {
        LocalTest localTest = new LocalTest();
        localTest.saveTrade();
        localTest.saveTrade();

        localTest.saveTrade();
        localTest.saveTrade(); localTest.saveTrade();
        localTest.saveTrade();
        localTest.saveTrade();
        localTest.saveTrade();

    }

    public void saveTrade() {
        Trade trade = new MiniTrade().getTrade(1);
        System.out.println(getTradeJson(trade));
    }

    public void testEnum() {
        System.out.println(HealthEnum.HEALTHY.getHealthStatus());
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
