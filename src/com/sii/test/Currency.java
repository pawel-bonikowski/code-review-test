package com.sii.test;

public class Currency {
    public static void main(String... varargs) {
        Double value = 121.11d;
        Double currencyExchange = 4.10d;
        Double newCurrencyValue = value * currencyExchange;
        System.out.println("After exchange: " + newCurrencyValue);
    }
}

