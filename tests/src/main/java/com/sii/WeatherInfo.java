package com.sii;

import java.math.BigDecimal;

public record WeatherInfo(
        BigDecimal temperature,
        String rainInfo,
        BigDecimal windSpeed
) {

    @Override
    public String toString() {
        return
                "temperatura = " + temperature +
                        ", opady=" + rainInfo +
                        ", predkość wiatru =" + windSpeed + "m/s";
    }
}
