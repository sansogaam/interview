package com.katta.test.validator;

import com.katta.test.builder.Builder;
import com.katta.test.builder.TradeBuilder;
import com.katta.test.model.Trade;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TradeValidatorTest {

    @Test
    public void testValidateVersionForEmptyTradeIds() {
        //Given
        Builder builder = new TradeBuilder();
        Trade tradeToBeAdded = builder.buildTrade()
                .withTradeId("T-1")
                .withVersion(1)
                .withCounterPartyId("CP-1")
                .withCreatedDate(new Date()).build();
        List<Trade> sameTradeIds = Arrays.asList();
        //When
        Validator validator = new TradeValidator();
        boolean validated = validator.validateVersion(tradeToBeAdded, sameTradeIds);
        //Then
        assertTrue(validated);
    }

    @Test
    public void testValidateVersionForStoredLessVersionTradeIds(){
        //Given
        Builder builder = new TradeBuilder();
        Trade tradeToBeAdded = builder.buildTrade()
                .withTradeId("T-1")
                .withVersion(3)
                .withCounterPartyId("CP-1")
                .withCreatedDate(new Date()).build();

        Trade trade1 = builder.buildTrade()
                .withTradeId("T-1")
                .withVersion(1)
                .withCounterPartyId("CP-1")
                .withCreatedDate(new Date()).build();

        Trade trade2 = builder.buildTrade()
                .withTradeId("T-1")
                .withVersion(2)
                .withCounterPartyId("CP-1")
                .withCreatedDate(new Date()).build();

        List<Trade> sameTradeIds = Arrays.asList(trade1, trade2);

        //When
        Validator validator = new TradeValidator();
        boolean validated = validator.validateVersion(tradeToBeAdded, sameTradeIds);
        //Then
        assertTrue(validated);
    }
    @Test
    public void testValidateVersionForStoredHigherVersionTradeIds(){
        //Given
        Builder builder = new TradeBuilder();
        Trade tradeToBeAdded = builder.buildTrade()
                .withTradeId("T-1")
                .withVersion(2)
                .withCounterPartyId("CP-1")
                .withCreatedDate(new Date()).build();

        Trade trade1 = builder.buildTrade()
                .withTradeId("T-1")
                .withVersion(1)
                .withCounterPartyId("CP-1")
                .withCreatedDate(new Date()).build();

        Trade trade2 = builder.buildTrade()
                .withTradeId("T-1")
                .withVersion(3)
                .withCounterPartyId("CP-1")
                .withCreatedDate(new Date()).build();

        List<Trade> sameTradeIds = Arrays.asList(trade1, trade2);

        //When
        Validator validator = new TradeValidator();
        boolean validated = validator.validateVersion(tradeToBeAdded, sameTradeIds);
        //Then
        assertFalse(validated);
    }
    @Test
    public void testValidateVersionForStoredSameVersionTradeId(){
        //Given
        Builder builder = new TradeBuilder();
        Trade tradeToBeAdded = builder.buildTrade()
                .withTradeId("T-1")
                .withVersion(2)
                .withCounterPartyId("CP-1")
                .withCreatedDate(new Date()).build();

        Trade trade1 = builder.buildTrade()
                .withTradeId("T-1")
                .withVersion(1)
                .withCounterPartyId("CP-1")
                .withCreatedDate(new Date()).build();

        Trade trade2 = builder.buildTrade()
                .withTradeId("T-1")
                .withVersion(2)
                .withCounterPartyId("CP-1")
                .withCreatedDate(new Date()).build();

        List<Trade> sameTradeIds = Arrays.asList(trade1, trade2);

        //When
        Validator validator = new TradeValidator();
        boolean validated = validator.validateVersion(tradeToBeAdded, sameTradeIds);
        //Then
        assertFalse(validated);
    }

}