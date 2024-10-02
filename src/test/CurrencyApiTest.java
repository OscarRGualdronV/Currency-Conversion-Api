package com.currencyconverter.app;

import com.currencyconverter.api.CurrencyApiClient;
import com.currencyconverter.model.CurrencyRatesResponse;

public class CurrencyApiTest {

    public static void main(String[] args) {
        CurrencyApiClient apiClient = new CurrencyApiClient();
        try {
            CurrencyRatesResponse rates = apiClient.fetchExchangeRate();
            System.out.println("Tasas de cambio obtenidas:");
            System.out.println(rates);
        }catch (Exception e) {
            System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
        }
    }
}
