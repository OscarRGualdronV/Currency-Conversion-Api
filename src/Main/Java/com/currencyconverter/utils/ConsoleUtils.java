package com.currencyconverter.utils;

public class ConsoleUtils {
    public static void clearConsole() {
        try {
            // Windows
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else { // Linux y Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.err.println("No se pudo limpiar la consola.");
        }
    }
}
