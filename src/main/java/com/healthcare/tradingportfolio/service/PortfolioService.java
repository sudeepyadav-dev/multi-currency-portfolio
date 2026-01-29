package com.healthcare.tradingportfolio.service;

import com.healthcare.tradingportfolio.enums.TransactionType;
import com.healthcare.tradingportfolio.model.PortfolioEntry;
import com.healthcare.tradingportfolio.model.Transaction;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortfolioService {

    private final ExchangeRateProvider rateProvider;
    private final Map<String, PortfolioEntry> portfolio = new HashMap<>();

    public PortfolioService(ExchangeRateProvider rateProvider) {
        this.rateProvider = rateProvider;
    }

    public void processTransactions(List<Transaction> transactions) {

        for (Transaction tx : transactions) {

            BigDecimal usdAmount = calculateUsdAmount(tx);
            String ticker = tx.getTicker();

            PortfolioEntry entry =
                    portfolio.computeIfAbsent(ticker, PortfolioEntry::new);

            if (tx.getType() == TransactionType.BUY) {
                handleBuy(entry, tx.getQuantity(), usdAmount);
            } else {
                handleSell(entry, tx.getQuantity(), usdAmount);
            }
        }
    }

    private BigDecimal calculateUsdAmount(Transaction tx) {
        BigDecimal localTotal =
                tx.getLocalPrice().multiply(BigDecimal.valueOf(tx.getQuantity()));

        BigDecimal rate =
                rateProvider.getRate(tx.getDate(), tx.getCurrency());

        return localTotal.multiply(rate);
    }

    private void handleBuy(PortfolioEntry entry,
                           int quantity,
                           BigDecimal usdAmount) {

        entry.addShares(quantity);
        entry.addUsdAmount(usdAmount);
    }

    private void handleSell(PortfolioEntry entry,
                            int quantity,
                            BigDecimal usdAmount) {

        if (entry.getTotalShares() < quantity) {
            System.err.println(
                    "Invalid SELL skipped for " + entry.getTicker()
                            + " | Available shares: "
                            + entry.getTotalShares()
                            + ", Tried to sell: "
                            + quantity
            );
            return;
        }

        entry.removeShares(quantity);
        entry.subtractUsdAmount(usdAmount);
    }

    public Map<String, PortfolioEntry> getPortfolio() {
        return portfolio;
    }
}
