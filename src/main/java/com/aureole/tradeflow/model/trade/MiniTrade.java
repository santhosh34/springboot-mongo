package com.aureole.tradeflow.model.trade;

import com.aureole.tradeflow.model.payloads.ContractDetails;
import com.aureole.tradeflow.model.payloads.Meta;
import com.aureole.tradeflow.model.payloads.Trade;

import java.time.Instant;

public class MiniTrade extends TradeEntity {
    private static final String  META_GLOBAL_KEY = "MiniTrade";
    private static final String  META_EXTERNAL_KEY = "MiniTrade";
    private static final String  FILE_NAME = "25KB.json";

    public String getMetaGlobalKey(){
        return META_GLOBAL_KEY;
    }

    public String getMetaExternalKey(){
        return META_EXTERNAL_KEY;
    }

    public String getFileName(){
        return FILE_NAME;
    }

}
