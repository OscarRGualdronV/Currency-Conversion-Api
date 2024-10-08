package com.currencyconverter.api;

import com.currencyconverter.model.CurrencyCodesResponse;
import com.currencyconverter.model.CurrencyRatesResponse;
import com.google.gson.Gson;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyApiClient {
    private static final String API_KEY = "1d2bcbb24c3d4a73152c8bbe";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY;

    public CurrencyRatesResponse fetchExchangeRate() throws Exception {
        String url = API_URL + "/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Failed to fetch exchange rate. Status code: " + response.statusCode());
        }

        Gson gson = new Gson();
        return gson.fromJson(response.body(), CurrencyRatesResponse.class);
    }

    public CurrencyCodesResponse fetchCurrencyCodes() throws Exception {
        String url =  API_URL + "/codes";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Failed to fetch currency codes. Status code: " + response.statusCode());
        }

        Gson gson = new Gson();
        return gson.fromJson(response.body(), CurrencyCodesResponse.class);
    }
}
