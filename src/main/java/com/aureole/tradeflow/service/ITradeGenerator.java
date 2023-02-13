package com.aureole.tradeflow.service;

import com.aureole.tradeflow.model.payloads.Trade;

public interface ITradeGenerator {

    Trade generateNextTrade();

    Trade getTrade();
}
