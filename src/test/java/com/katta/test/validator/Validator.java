package com.katta.test.validator;

import com.katta.test.model.Trade;

import java.util.List;

public interface Validator {
    boolean validateVersion(Trade tradeToBeAdded , List<Trade> sameTradeIds);
    boolean validateMaturityDate();
}
