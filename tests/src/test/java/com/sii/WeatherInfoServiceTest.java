package com.sii;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
  Review the test and apply fixes if needed
 */
class WeatherInfoServiceTest {

    @Test
    void testWeatherService() throws JsonProcessingException {
        WeatherInfoService weatherInfoService = new WeatherInfoService();
        WeatherInfo warszawa = weatherInfoService.getSomeData("warszawa");

        assertNotNull(warszawa);
        assertNotNull(warszawa.rainInfo());
        assertNotNull(warszawa.temperature());
        assertNotNull(warszawa.windSpeed());
    }


}
