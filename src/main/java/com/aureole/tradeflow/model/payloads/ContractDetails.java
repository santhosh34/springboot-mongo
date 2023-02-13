package com.aureole.tradeflow.model.payloads;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import netscape.javascript.JSObject;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetails {

    private int contractId;

    private JsonNode description;
    
}
