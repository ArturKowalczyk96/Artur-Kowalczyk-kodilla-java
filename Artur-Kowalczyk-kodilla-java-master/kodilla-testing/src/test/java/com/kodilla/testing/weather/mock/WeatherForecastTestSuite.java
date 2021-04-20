package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    private static int counter = 0;
    private Map<String, Double> generateTemperaturesMap () {
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("Rzeszów", 25.5);
        resultMap.put("Kraków", 26.2);
        resultMap.put("Wrocłąw", 24.8);
        resultMap.put("Warszawa", 25.2);
        resultMap.put("Gdańsk", 26.3);
        return resultMap;
    }


    @Mock
    private static Temperatures temperaturesMock;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Test Suite: end");
    }

    @BeforeEach
    public void beforeEach(){
        counter++;
        System.out.println("Test: #" + counter);
    }

    @Test
    void testCalculateForecastWithMock(){
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        Map<String, Double> temperaturesMap = generateTemperaturesMap();
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAverageTemperature(){
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        Map<String, Double> temperaturesMap = generateTemperaturesMap();
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //When
        double averageTemperature = weatherForecast.calculateAverage();

        //Then
        Assertions.assertEquals(25.6, averageTemperature);
    }

    @Test
    void testCalculateMedianOfTemperature(){
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        Map<String, Double> temperaturesMap = generateTemperaturesMap();
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //When
        double medianTemperature = weatherForecast.calculateMedian();

        //Then
        Assertions.assertEquals(25.5, medianTemperature);
    }
}
