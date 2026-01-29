package com.healthcare.tradingportfolio.model;

import java.math.BigDecimal;

public class PortfolioEntry {

    private String ticker;
    private int totalShares;
    private BigDecimal totalUsdAmount;

    public PortfolioEntry(String ticker) {
        this.ticker = ticker;
        this.totalShares = 0;
        this.totalUsdAmount = BigDecimal.ZERO;
    }

    public String getTicker() {
        return ticker;
    }

    public int getTotalShares() {
        return totalShares;
    }

    public BigDecimal getTotalUsdAmount() {
        return totalUsdAmount;
    }

    // These methods will be used by PortfolioService

    public void addShares(int quantity) {
        this.totalShares += quantity;
    }

    public void removeShares(int quantity) {
        this.totalShares -= quantity;
    }

    public void addUsdAmount(BigDecimal amount) {
        this.totalUsdAmount = this.totalUsdAmount.add(amount);
    }

    public void subtractUsdAmount(BigDecimal amount) {
        this.totalUsdAmount = this.totalUsdAmount.subtract(amount);
    }
}
