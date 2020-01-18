package com.katta.test.store;

import com.katta.test.builder.Builder;
import com.katta.test.builder.TradeBuilder;
import com.katta.test.model.Trade;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MapTradeStoreTest {

    @Test
    public void storeFirstTradeObject() {
        //Given conditions
        Builder builder = new TradeBuilder();
        Trade trade = builder.buildTrade()
                .withTradeId("T-1")
                .withVersion("V1")
                .withCounterPartyId("CP-1")
                .withCreatedDate(new Date()).build();
        System.out.println(trade);
        TradeStore tradeStore = new MapTradeStore();
        //When
        tradeStore.storeTrade(trade);
        //Then
        Map<String, Trade> mapOfTrades = tradeStore.getReferenceTradeStore();
        assertEquals(mapOfTrades.size(), 1);
    }
}