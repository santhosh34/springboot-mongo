package com.aureole.tradeflow.service.impl;

import com.aureole.tradeflow.model.payloads.Trade;
import com.aureole.tradeflow.service.ITradeGenerator;

import java.time.Instant;

/**
 * Not in USe for Bulk Insert
 */
public abstract class TradeGenerator implements ITradeGenerator {

    private static final int BATCH_SIZE = 5;

    private static int externalRefNumber =1;
    private static int batchNumber =1;

    public abstract Trade generateSingleTrade();
    @Override
    public Trade generateNextTrade() {
        Trade trade = new Trade();
        trade.setTradeTime(Instant.now());
        trade.setExternalRefNumber(getNextTradeExternalRefNumber());
        trade.setBatchNumber(getBatchNumber());
        return trade;
    }
    private int getNextTradeExternalRefNumber(){
        return  externalRefNumber++;
    }

    private int getBatchNumber(){
        if( externalRefNumber % BATCH_SIZE == 1){
            return batchNumber++;
        }
        return  batchNumber;
    }
}
