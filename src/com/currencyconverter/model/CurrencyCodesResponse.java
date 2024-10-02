package com.currencyconverter.model;

import java.util.List;

public class CurrencyCodesResponse {
    public String result;
    public List<String[]> supported_codes; // List of [code, currency_name]

    public boolean isSuccess() {
        return "success".equals(result);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<String[]> getSupported_codes() {
        return supported_codes;
    }

    public void setSupported_codes(List<String[]> supported_codes) {
        this.supported_codes = supported_codes;
    }
}
