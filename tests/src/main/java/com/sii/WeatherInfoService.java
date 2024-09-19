package com.sii;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

public class WeatherInfoService {

    private final static String API_URL = "https://danepubliczne.imgw.pl/api/data/synop/station/%s";
    private final ObjectMapper mapper = new ObjectMapper();

    WeatherInfo getSomeData(String city) throws JsonProcessingException {

        String data = HttpCallHelper.getData(String.format(API_URL, city));
        JsonNode jsonNode = mapper.readTree(data);
        JsonNode temperatureInfo = jsonNode.findValue("temperatura");
        JsonNode rainInfo = jsonNode.findValue("suma_opadu");
        JsonNode windSpeed = jsonNode.findValue("predkosc_wiatru");
        return new WeatherInfo(new BigDecimal(temperatureInfo.asText()), rainInfo.asText(), new BigDecimal(windSpeed.asText()));
    }

}
