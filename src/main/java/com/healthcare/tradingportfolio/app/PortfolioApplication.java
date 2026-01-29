package com.healthcare.tradingportfolio.app;

import com.healthcare.tradingportfolio.enums.TransactionType;
import com.healthcare.tradingportfolio.model.ExchangeRate;
import com.healthcare.tradingportfolio.model.Transaction;
import com.healthcare.tradingportfolio.reports.PortfolioReportGenerator;
import com.healthcare.tradingportfolio.service.ExchangeRateProvider;
import com.healthcare.tradingportfolio.service.PortfolioService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PortfolioApplication {

    public static void main(String[] args) {

        // 1. Prepare exchange rates
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        exchangeRates.add(new ExchangeRate(
                LocalDate.of(2024, 1, 10), "EUR", new BigDecimal("1.10")
        ));
        exchangeRates.add(new ExchangeRate(
                LocalDate.of(2024, 1, 10), "GBP", new BigDecimal("1.25")
        ));

        ExchangeRateProvider rateProvider = new ExchangeRateProvider(exchangeRates);

        // 2. Prepare transactions
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(
                LocalDate.of(2024, 1, 10),
                "AAPL",
                TransactionType.BUY,
                10,
                new BigDecimal("50"),
                "EUR"
        ));

        transactions.add(new Transaction(
                LocalDate.of(2024, 1, 10),
                "AAPL",
                TransactionType.SELL,
                4,
                new BigDecimal("55"),
                "EUR"
        ));

        // 3. Process portfolio
        PortfolioService portfolioService = new PortfolioService(rateProvider);
        portfolioService.processTransactions(transactions);

        // 4. Generate report
        PortfolioReportGenerator reportGenerator =
                new PortfolioReportGenerator(portfolioService.getPortfolio());

        reportGenerator.printReport();
    }
}
