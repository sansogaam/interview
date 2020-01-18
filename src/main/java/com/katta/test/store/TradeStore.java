package com.katta.test.store;

import com.katta.test.model.Trade;

import java.util.Map;

public interface TradeStore {

    void storeTrade(Trade trade);
    Map<String, Trade> getReferenceTradeStore();

}
