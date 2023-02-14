package com.aureole.tradeflow.model.trade;

import com.aureole.tradeflow.constants.TradeSizeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeType {

    private int count;
    private String size;

}
