package com.aureole.tradeflow.model.payloads;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("trade")
public class Trade {

    @Id
    private String id;
    private Instant tradeTime;
    private Meta meta;
    private Party party;
    private int batchNumber; // Let's say batch size is 10,000.. and if we have 100,000th record will be in 10th batch.
    private int externalRefNumber;
    private ContractDetails contractDetails;

}
