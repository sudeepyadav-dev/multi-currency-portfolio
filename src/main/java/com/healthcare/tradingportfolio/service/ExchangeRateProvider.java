package com.healthcare.tradingportfolio.service;

import com.healthcare.tradingportfolio.model.ExchangeRate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExchangeRateProvider {

    // date -> (currency -> rate)
    private final Map<LocalDate, Map<String, BigDecimal>> rateMap = new HashMap<>();

    public ExchangeRateProvider(List<ExchangeRate> exchangeRates) {
        for (ExchangeRate rate : exchangeRates) {
            rateMap
                    .computeIfAbsent(rate.getDate(), d -> new HashMap<>())
                    .put(rate.getCurrency(), rate.getRateToUsd());
        }
    }

    public BigDecimal getRate(LocalDate date, String currency) {
        Map<String, BigDecimal> dailyRates = rateMap.get(date);

        if (dailyRates == null || !dailyRates.containsKey(currency)) {
            throw new IllegalArgumentException(
                    "Exchange rate not found for date " + date + " and currency " + currency
            );
        }

        return dailyRates.get(currency);
    }
}
