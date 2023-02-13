package com.aureole.tradeflow.model.trade;

import com.aureole.tradeflow.model.payloads.ContractDetails;
import com.aureole.tradeflow.model.payloads.Meta;
import com.aureole.tradeflow.model.payloads.Trade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.stream.Collectors;


public class LargeTrade extends  TradeEntity{

    private static final String  META_GLOBAL_KEY = "LargeTrade";
    private static final String  META_EXTERNAL_KEY = "LargeTrade";

    private static final String  FILE_NAME = "1MB.json";

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
