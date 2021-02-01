package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void openSettingsFile() {
        logger = Logger.ENTER;
        logger.log("New log no.01");
    }

    @AfterAll
    public static void closeSettingsFile() {
        System.out.println("End of test");
    }

    @Test
    void testGetLastLog() {
        //Given
        //When
        String lastLog = logger.getLastLog();
        System.out.println("Last log: " + lastLog);
        //Then
        assertEquals("New log no.01", lastLog);
    }
}
