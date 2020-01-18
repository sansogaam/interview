package com.katta.test.builder;

import com.katta.test.model.Trade;

import java.util.Date;

public class TradeBuilder implements Builder{

    private String tradeId;
    private String version;
    private String bookId;
    private String counterPartyId;
    private Date createdDate;
    private Date maturityDate;
    private boolean expired;

    public TradeBuilder withTradeId(String tradeId){
        this.tradeId = tradeId;
        return  this;
    }

    public TradeBuilder withVersion(String version){
        this.version = version;
        return this;
    }

    public TradeBuilder withBookId(String bookId){
        this.bookId = bookId;
        return this;
    }

    public TradeBuilder withCounterPartyId(String counterPartyId){
        this.counterPartyId = counterPartyId;
        return this;
    }

    public TradeBuilder withCreatedDate(Date createdDate){
        this.createdDate = createdDate;
        return this;
    }

    public TradeBuilder withMaturityDate(Date maturityDate){
        this.maturityDate = maturityDate;
        return this;
    }

    public TradeBuilder withExpired(boolean expired){
        this.expired = expired;
        return this;
    }


    @Override
    public TradeBuilder buildTrade() {
        return new TradeBuilder();
    }

    public Trade build(){
        Trade trade = new Trade();
        trade.setTradeId(tradeId);
        trade.setVersion(version);
        trade.setBookId(bookId);
        trade.setCounterPartyId(counterPartyId);
        trade.setCreatedDate(createdDate);
        trade.setMaturityDate(maturityDate);
        trade.setExpired(expired);
        return trade;
    }
}
