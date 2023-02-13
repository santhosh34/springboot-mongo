package com.aureole.tradeflow.model.trade;

import com.aureole.tradeflow.model.payloads.ContractDetails;
import com.aureole.tradeflow.model.payloads.Meta;
import com.aureole.tradeflow.model.payloads.Trade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Instant;

public class TradeEntity {

    protected   Trade trade;
    protected Meta meta;

    public Trade getTrade(int i) {
     return null;

    }

    protected static String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }


}
