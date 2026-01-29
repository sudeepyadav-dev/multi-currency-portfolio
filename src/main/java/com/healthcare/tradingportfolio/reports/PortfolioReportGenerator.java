package com.healthcare.tradingportfolio.reports;

import com.healthcare.tradingportfolio.model.PortfolioEntry;

import java.math.BigDecimal;
import java.util.Map;

public class PortfolioReportGenerator {

    private final Map<String, PortfolioEntry> portfolio;

    public PortfolioReportGenerator(Map<String, PortfolioEntry> portfolio) {
        this.portfolio = portfolio;
    }

    public void printReport() {

        System.out.println("----- Portfolio Report (USD) -----");

        for (PortfolioEntry entry : portfolio.values()) {

            if (entry.getTotalShares() > 0) {
                System.out.println(
                        "Ticker: " + entry.getTicker()
                                + " | Shares: " + entry.getTotalShares()
                                + " | Total USD: " + formatAmount(entry.getTotalUsdAmount())
                );
            }
        }
        System.out.println("----- End of Report -----");
    }

    private String formatAmount(BigDecimal amount) {
        return amount.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }
}
