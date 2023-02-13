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

    private static String description="";

    public Trade getTrade(int i) {
        trade = new Trade();
        trade.setTradeTime(Instant.now());
        meta = new Meta();
        meta.setGlobalKey("LargeTrade");
        meta.setExternalKey("LargeTrade");
        trade.setMeta(meta);
        trade.setContractDetails(getContractDetails(i));
        trade.setExternalRefNumber(i);
        return trade;
    }

    public static ContractDetails getContractDetails(int i ) {

        ContractDetails contractDetails = new ContractDetails();
        contractDetails.setContractId(i);

        if(description.isEmpty()){
            ClassLoader classLoader = LargeTrade.class.getClassLoader();
            InputStream  inputStream=classLoader.getResourceAsStream("1MB.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            description =  (String)reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
        contractDetails.setDescription(description);
        return contractDetails;
    }

}
