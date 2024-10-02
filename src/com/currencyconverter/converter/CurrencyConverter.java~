package com.currencyconverter.converter;

import java.util.Map;

public class CurrencyConverter {

    // Metodo para obtener la tasa de conversión entre dos monedas

    public static double getConversionRate(String fromCurrency, String toCurrency, Map<String, Double> conversionRates) {
        Double fromRate = conversionRates.get(fromCurrency);
        Double toRate = conversionRates.get(toCurrency);

        if (fromRate == null || toRate == null) {
            throw new IllegalArgumentException("Moneda no encontrada en las tasas de conversión.");
        }

        // Tasa de conversión relativa entre la moneda de origen y la moneda destino
        return toRate / fromRate;
    }

    // Método para convertir un valor entre dos monedas
    public static double convertCurrency(double amount, double conversionRate) {
        return amount * conversionRate;
    }

    // Método para convertir entre dos monedas, dada una cantidad
    public static double convert(double amount, String fromCurrency, String toCurrency, Map<String, Double> conversionRates) {
        double conversionRate = getConversionRate(fromCurrency, toCurrency, conversionRates);
        return convertCurrency(amount, conversionRate);
    }
}
