package com.katta.test.validator;

import com.katta.test.model.Trade;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TradeValidator implements Validator{

    @Override
    public boolean validateVersion(Trade tradeToBeAdded, List<Trade> sameTradeIds) {
        if(sameTradeIds.isEmpty()){
            return true;
        }else{
            List<Trade> higherVersionTradeIdsExist = sameTradeIds.stream()
                    .filter(trade -> trade.getVersion() >= tradeToBeAdded.getVersion())
                    .collect(Collectors.toList());
            if(higherVersionTradeIdsExist.isEmpty()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validateMaturityDate(Trade tradeToBeAdded) {
        if(new Date().before(tradeToBeAdded.getMaturityDate())){
            return true;
        }
        return false;
    }
}
