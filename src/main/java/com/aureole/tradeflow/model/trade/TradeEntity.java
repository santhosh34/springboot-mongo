package com.aureole.tradeflow.model.trade;

import com.aureole.tradeflow.model.payloads.ContractDetails;
import com.aureole.tradeflow.model.payloads.Meta;
import com.aureole.tradeflow.model.payloads.Trade;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.bson.json.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.stream.Collectors;

public class TradeEntity {

    protected Trade trade;

    protected Meta meta;

    protected static JsonNode description = null;

    private static final int batchSize = 10000;

    public Trade getTrade(int i) {
        trade = getTradeSkeleton();
        trade.setTradeTime(Instant.now());
        meta = getMetaSkeleton();
        meta.setGlobalKey(getMetaGlobalKey());
        meta.setExternalKey(getMetaExternalKey());
        trade.setMeta(meta);
        trade.setContractDetails(getContractDetails(i));
        trade.setExternalRefNumber(i);
        trade.setBatchNumber((i/ batchSize) + 1);
        return trade;
    }

    public Trade getTradeSkeleton() {
        return new Trade();
    }

    public Meta getMetaSkeleton() {
        return new Meta();
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

    public ContractDetails getContractDetails(int i) {

        ContractDetails contractDetails = getNewContractDetails();
        contractDetails.setContractId(i);

        if (description == null ) {
            description= reloadDescription();
        }
        contractDetails.setDescription(description);
        return contractDetails;
    }

    public  ContractDetails getNewContractDetails(){
        return new ContractDetails();
    }

    public JsonNode reloadDescription(){
        ClassLoader classLoader = SmallTrade.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(getFileName());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String descriptionAsString= (String) reader.lines().collect(Collectors.joining(System.lineSeparator()));
        JsonNode jsonNode;
        try {
            jsonNode = new ObjectMapper().readTree(descriptionAsString);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonNode;
    }

    protected String getFileName(){
        return null;
    }

    public String getMetaGlobalKey(){
        return null;
    }

    public String getMetaExternalKey(){
        return null;
    }

}
