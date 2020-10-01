package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.ststistics.CalculateStatistics;
import com.kodilla.testing.forum.ststistics.Statistics;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    private static int testCounter = 0;
    private List<String> generateListOfUsers(int usersNumber) {
        List<String> resultListOfUsers = new ArrayList<>();
        for (int i = 0; i < usersNumber; i++) {
            String user = new String("User: " + i);
            resultListOfUsers.add(user);
        }
        return resultListOfUsers;
    }

    @Mock
    private Statistics statisticsMock;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test suite: begin");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Test suite: end");
    }

    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Test calculateAdvStatistics")
    class TestCalculateAdvStatistics {
        @Test
        void testCalculateAdvStatisticsFor0Posts() {
            //given
            CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
            List<String> resultListOfUsers = generateListOfUsers(100);
            int resultPostCount = 0;
            int resultCommentsCount = 100;
            when(statisticsMock.usersNames()).thenReturn(resultListOfUsers);
            when(statisticsMock.postsCount()).thenReturn(resultPostCount);
            when(statisticsMock.commentsCount()).thenReturn(resultCommentsCount);

            //when
            var map = calculateStatistics.calculateAdvStatistics(statisticsMock);
            double result = map.get("Nufd");
            System.out.println(calculateStatistics);

            //then
            assertEquals(0.0, result);
            System.out.println(result);
        }
        @Test
        void testCalculateAdvStatisticsFor(){
            Map<String, Boolean> hashMap = new HashMap<>();
            hashMap.put("aa", false);
            boolean  result = hashMap.get("aa");
            System.out.println(result);

        }
    }
}
