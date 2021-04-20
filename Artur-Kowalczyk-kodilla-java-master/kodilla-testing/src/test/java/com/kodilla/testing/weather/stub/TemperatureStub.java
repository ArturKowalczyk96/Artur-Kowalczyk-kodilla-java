package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;

public class TemperatureStub implements Temperatures {

    @Override
    public Map<String, Double> getTemperatures() {
        Map<String, Double> stubResult = new HashMap<>();

        //dummy data
        stubResult.put("Rzeszow", 25.5);
        stubResult.put("Kraków", 26.2);
        stubResult.put("Wrocław", 24.8);
        stubResult.put("Warszwa", 25.2);
        stubResult.put("Gdańsk", 26.1);

        return stubResult;
    }
}
