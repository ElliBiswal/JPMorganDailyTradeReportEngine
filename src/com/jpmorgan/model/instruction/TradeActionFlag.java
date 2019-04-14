package com.jpmorgan.model.instruction;

public enum TradeActionFlag {
    BUY("B"),
    SELL("S");

    private String text;

    TradeActionFlag(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
