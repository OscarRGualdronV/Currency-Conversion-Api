package com.currencyconverter.app;

import com.currencyconverter.api.CurrencyApiClient;
import com.currencyconverter.converter.CurrencyConverter;
import com.currencyconverter.model.CurrencyCodesResponse;
import com.currencyconverter.model.CurrencyRatesResponse;
import com.currencyconverter.utils.ConsoleUtils;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CurrencyApiClient apiClient = new CurrencyApiClient();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            try {
                ConsoleUtils.clearConsole();
                System.out.println("\n--- Conversor de Monedas ---");
                System.out.println("1. Convertir Moneda");
                System.out.println("2. Salir");
                System.out.print("Seleccione una opcion: ");
                int option = scanner.nextInt();

                if (option == 2) {
                    exit = true;
                    System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
                    break;
                }

                if (option == 1) {
                    CurrencyRatesResponse rates = apiClient.fetchExchangeRate();
                    CurrencyCodesResponse codes = apiClient.fetchCurrencyCodes();

                    if (!"success".equalsIgnoreCase(rates.getResultado())){
                        System.out.println("Error obteniendo las tasas de cambio.");
                        continue;
                    }

                    System.out.println("Seleccione la moneda de origen:");
                    for (int i = 0; i < codes.getSupported_codes().size(); i++) {
                        String[] currency = codes.getSupported_codes().get(i);
                        System.out.println((i + 1) + ". " + currency[0] + " - " + currency[1]);
                    }

                    System.out.println("Ingrese el número de la moneda de origen: ");
                    int origenindex = scanner.nextInt() - 1;
                    String monedaOrigen = codes.getSupported_codes().get(origenindex)[0];

                    System.out.println("Ingrese el número de la moneda de destino: ");
                    int destinoindex = scanner.nextInt() - 1;
                    String monedaDestino = codes.getSupported_codes().get(destinoindex)[0];

                    System.out.println("Ingrese la cantidad a convertir: ");
                    double cantidad = scanner.nextDouble();

                    Map<String, Double> conversionRates = rates.getConversion_rates();
                    double conversionRate = CurrencyConverter.getConversionRate(monedaOrigen, monedaDestino, conversionRates);

                    double conversion = CurrencyConverter.convert(cantidad, monedaOrigen, monedaDestino, conversionRates);

                    System.out.println(cantidad + " " + monedaOrigen + " equivalen a " + conversion + " " + monedaDestino);
                }else {
                    System.out.println("Opción inválida. Por favor, ingrese un número entre 1 y 2.");
                }
            }catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
                scanner.nextLine();
        }
    } scanner.close();
    }
}



