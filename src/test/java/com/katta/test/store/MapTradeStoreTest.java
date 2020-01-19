package com.katta.test.store;

import com.katta.test.builder.Builder;
import com.katta.test.builder.TradeBuilder;
import com.katta.test.model.Trade;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MapTradeStoreTest {

    @Test
    public void storeFirstTradeObject() {
        //Given conditions
        Builder builder = new TradeBuilder();
        Trade trade = builder.buildTrade()
                .withTradeId("T-1")
                .withVersion(1)
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

    @Test
    public void storeTradeObjectAndCheckItsDetail() {
        Builder builder = new TradeBuilder();
        Trade trade = builder.buildTrade()
                .withTradeId("T-1")
                .withVersion(1)
                .withCounterPartyId("CP-1")
                .withCreatedDate(new Date()).build();
        //When
        TradeStore tradeStore = new MapTradeStore();
        tradeStore.storeTrade(trade);
        //Then
        Map<String, Trade> mapOfTrades = tradeStore.getReferenceTradeStore();
        assertEquals(mapOfTrades.size(), 1);
        Trade storedTrade= mapOfTrades.get(trade.getTradeId() +"-" + trade.getVersion());
        assertNotNull(storedTrade);
        String counterPartyId = storedTrade.getCounterPartyId();
        assertEquals(counterPartyId, "CP-1");
        assertEquals(trade.getCreatedDate(), new Date());
    }
}