package com.sii;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        WeatherInfoService weatherInfoService = new WeatherInfoService();
        WeatherInfo gdansk = weatherInfoService.getSomeData("gdansk");
        System.out.println("Pogoda w Gdansku to : " + gdansk);

        WeatherInfo olsztyn = weatherInfoService.getSomeData("olsztyn");
        System.out.println("Pogoda w Olsztynie to : " + olsztyn);

        WeatherInfo warszawa = weatherInfoService.getSomeData("warszawa");
        System.out.println("Pogoda w Warszawie to : " + warszawa);

    }
}
