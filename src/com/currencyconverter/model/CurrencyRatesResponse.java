package com.currencyconverter.model;

import java.util.Map;

public class CurrencyRatesResponse {
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;


    public String getResultado() {
        return result;
    }

    public void setResultado(String resultado) {
        this.result = resultado;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }


    @Override
    public String toString() {
        return "CurrencyRatesResponse{" +
                "resultado='" + result + '\'' +
                ", baseCode='" + base_code + '\'' +
                ", conversionRates=" + conversion_rates +
                '}';
    }
}
