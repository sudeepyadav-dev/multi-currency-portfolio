package com.healthcare.tradingportfolio.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeRate {

    private LocalDate date;
    private String currency;
    private BigDecimal rateToUsd;

    public ExchangeRate(LocalDate date, String currency, BigDecimal rateToUsd) {
        this.date = date;
        this.currency = currency;
        this.rateToUsd = rateToUsd;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getRateToUsd() {
        return rateToUsd;
    }
}
