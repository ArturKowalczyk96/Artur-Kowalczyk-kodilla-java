package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculations() {
        //Given
        //When
        calculator.add(10, 5);
        calculator.sub(10, 5);
        calculator.div(10, 4);
        calculator.mul(2, 3.4);
        //Then
        //do nothing
    }

}
