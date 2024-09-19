package com.sii.test;

public class Currency {
    public static void main(String... varargs) {
        double value = 121.11d;
        double currencyExchange = 4.10d;
        double newCurrencyValue = value * currencyExchange;
        System.out.println("After exchange: " + newCurrencyValue);
    }
}

