package com.healthcare.tradingportfolio.model;

import com.healthcare.tradingportfolio.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {

    private LocalDate date;
    private String ticker;
    private TransactionType type;
    private int quantity;
    private BigDecimal localPrice;
    private String currency;

    public Transaction(LocalDate date,
                       String ticker,
                       TransactionType type,
                       int quantity,
                       BigDecimal localPrice,
                       String currency) {
        this.date = date;
        this.ticker = ticker;
        this.type = type;
        this.quantity = quantity;
        this.localPrice = localPrice;
        this.currency = currency;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTicker() {
        return ticker;
    }

    public TransactionType getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getLocalPrice() {
        return localPrice;
    }

    public String getCurrency() {
        return currency;
    }
}
