package com.aureole.tradeflow.model.trade;

import com.aureole.tradeflow.constants.TradeSizeEnum;

public class TradeFactory {

    public static TradeEntity getTradeEntityType(TradeType tradeType){

        switch(TradeSizeEnum.valueOf(tradeType.getSize())) {
            case SMALL:
                return new SmallTrade();
            case MEDIUM:
                return new MediumTrade();
            case LARGE:
                return new LargeTrade();
            case LARGEST:
                return new LargestTrade();
            default:
                return new MiniTrade();
        }
    }
}
