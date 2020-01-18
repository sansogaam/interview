package com.katta.test.store;

import com.katta.test.model.Trade;

import java.util.HashMap;
import java.util.Map;

public class MapTradeStore implements TradeStore {

    Map<String, Trade > mapofTrades = new HashMap<String, Trade>();

    @Override
    public void storeTrade(Trade trade) {
         mapofTrades.put("1", trade);
    }

    @Override
    public Map<String, Trade> getReferenceTradeStore() {
        return this.mapofTrades;
    }


}
