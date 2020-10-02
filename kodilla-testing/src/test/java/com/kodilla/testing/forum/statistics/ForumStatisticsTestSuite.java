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
            int resultCommentsCount = 0;
            when(statisticsMock.usersNames()).thenReturn(resultListOfUsers);
            when(statisticsMock.postsCount()).thenReturn(resultPostCount);
            when(statisticsMock.commentsCount()).thenReturn(resultCommentsCount);

            //when
            var map = calculateStatistics.calculateAdvStatistics(statisticsMock);
            double result1 = map.get("Number of users: ");
            double result2 = map.get("Number of posts: ");
            double result3 = map.get("Number of comments: ");
            double result4 = map.get("Average number of posts per user: ");
            double result5 = map.get("Average number of comments per user: ");
            double result6 = map.get("Number of posts: ");
            String showMap = calculateStatistics.showStatistics();

            //then
            assertEquals(100.0, result1);
            assertEquals(0.0, result2);
            assertEquals(0.0, result3);
            assertEquals(0.0, result4);
            assertEquals(0.0, result5);
            assertEquals(0.0, result6);
            System.out.println("Expected: 100.0; Result: " + result1);
            System.out.println("Expected: 0.0; Result: " + result2);
            System.out.println("Expected: 0.0; Result: " + result3);
            System.out.println("Expected: 0.0; Result: " + result4);
            System.out.println("Expected: 0.0; Result: " + result5);
            System.out.println("Expected: 0.0; Result: " + result6);
            System.out.println(showMap);
        }

        @Test
        void testCalculateAdvStatisticsFor1000Posts() {
            //given
            CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
            List<String> resultListOfUsers = generateListOfUsers(100);
            int resultPostCount = 1000;
            int resultCommentsCount = 0;
            when(statisticsMock.usersNames()).thenReturn(resultListOfUsers);
            when(statisticsMock.postsCount()).thenReturn(resultPostCount);
            when(statisticsMock.commentsCount()).thenReturn(resultCommentsCount);

            //when
            var map = calculateStatistics.calculateAdvStatistics(statisticsMock);
            double result1 = map.get("Number of users: ");
            double result2 = map.get("Number of posts: ");
            double result3 = map.get("Number of comments: ");
            double result4 = map.get("Average number of posts per user: ");
            double result5 = map.get("Average number of comments per user: ");
            double result6 = map.get("Average number of comments per post: ");
            String showMap = calculateStatistics.showStatistics();

            //then
            assertEquals(100.0, result1);
            assertEquals(1000.0, result2);
            assertEquals(0.0, result3);
            assertEquals(10.0, result4);
            assertEquals(0.0, result5);
            assertEquals(0.0, result6);
            System.out.println("Expected: 100.0; Result: " + result1);
            System.out.println("Expected: 1000.0; Result: " + result2);
            System.out.println("Expected: 0.0; Result: " + result3);
            System.out.println("Expected: 10.0; Result: " + result4);
            System.out.println("Expected: 0.0; Result: " + result5);
            System.out.println("Expected: 0.0; Result: " + result6);
            System.out.println(showMap);
        }

        @Test
        void testCalculateAdvStatisticsFor0Comments() {
            //given
            CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
            List<String> resultListOfUsers = generateListOfUsers(100);
            int resultPostCount = 1000;
            int resultCommentsCount = 0;
            when(statisticsMock.usersNames()).thenReturn(resultListOfUsers);
            when(statisticsMock.postsCount()).thenReturn(resultPostCount);
            when(statisticsMock.commentsCount()).thenReturn(resultCommentsCount);

            //when
            var map = calculateStatistics.calculateAdvStatistics(statisticsMock);
            double result1 = map.get("Number of users: ");
            double result2 = map.get("Number of posts: ");
            double result3 = map.get("Number of comments: ");
            double result4 = map.get("Average number of posts per user: ");
            double result5 = map.get("Average number of comments per user: ");
            double result6 = map.get("Average number of comments per post: ");
            String showMap = calculateStatistics.showStatistics();

            //then
            assertEquals(100.0, result1);
            assertEquals(1000.0, result2);
            assertEquals(0.0, result3);
            assertEquals(10.0, result4);
            assertEquals(0.0, result5);
            assertEquals(0.0, result6);
            System.out.println("Expected: 100.0; Result: " + result1);
            System.out.println("Expected: 1000.0; Result: " + result2);
            System.out.println("Expected: 0.0; Result: " + result3);
            System.out.println("Expected: 10.0; Result: " + result4);
            System.out.println("Expected: 0.0; Result: " + result5);
            System.out.println("Expected: 0.0; Result: " + result6);
            System.out.println(showMap);
        }

        @Test
        void testCalculateAdvStatisticsForLessCommentsThanPosts() {
            //given
            CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
            List<String> resultListOfUsers = generateListOfUsers(100);
            int resultPostCount = 1000;
            int resultCommentsCount = 100;
            when(statisticsMock.usersNames()).thenReturn(resultListOfUsers);
            when(statisticsMock.postsCount()).thenReturn(resultPostCount);
            when(statisticsMock.commentsCount()).thenReturn(resultCommentsCount);

            //when
            var map = calculateStatistics.calculateAdvStatistics(statisticsMock);
            double result1 = map.get("Number of users: ");
            double result2 = map.get("Number of posts: ");
            double result3 = map.get("Number of comments: ");
            double result4 = map.get("Average number of posts per user: ");
            double result5 = map.get("Average number of comments per user: ");
            double result6 = map.get("Average number of comments per post: ");
            String showMap = calculateStatistics.showStatistics();

            //then
            assertEquals(100.0, result1);
            assertEquals(1000.0, result2);
            assertEquals(100.0, result3);
            assertEquals(10.0, result4);
            assertEquals(1.0, result5);
            assertEquals(0.1, result6);
            System.out.println("Expected: 100.0; Result: " + result1);
            System.out.println("Expected: 1000.0; Result: " + result2);
            System.out.println("Expected: 100.0; Result: " + result3);
            System.out.println("Expected: 10.0; Result: " + result4);
            System.out.println("Expected: 1.0; Result: " + result5);
            System.out.println("Expected: 0.1; Result: " + result6);
            System.out.println(showMap);
        }

        @Test
        void testCalculateAdvStatisticsForMoreCommentsThanPosts() {
            //given
            CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
            List<String> resultListOfUsers = generateListOfUsers(100);
            int resultPostCount = 100;
            int resultCommentsCount = 1000;
            when(statisticsMock.usersNames()).thenReturn(resultListOfUsers);
            when(statisticsMock.postsCount()).thenReturn(resultPostCount);
            when(statisticsMock.commentsCount()).thenReturn(resultCommentsCount);

            //when
            var map = calculateStatistics.calculateAdvStatistics(statisticsMock);
            double result1 = map.get("Number of users: ");
            double result2 = map.get("Number of posts: ");
            double result3 = map.get("Number of comments: ");
            double result4 = map.get("Average number of posts per user: ");
            double result5 = map.get("Average number of comments per user: ");
            double result6 = map.get("Average number of comments per post: ");
            String showMap = calculateStatistics.showStatistics();

            //then
            assertEquals(100.0, result1);
            assertEquals(100.0, result2);
            assertEquals(1000.0, result3);
            assertEquals(1.0, result4);
            assertEquals(10.0, result5);
            assertEquals(10.0, result6);
            System.out.println("Expected: 100.0; Result: " + result1);
            System.out.println("Expected: 100.0; Result: " + result2);
            System.out.println("Expected: 1000.0; Result: " + result3);
            System.out.println("Expected: 1.0; Result: " + result4);
            System.out.println("Expected: 10.0; Result: " + result5);
            System.out.println("Expected: 10.0; Result: " + result6);
            System.out.println(showMap);
        }

        @Test
        void testCalculateAdvStatisticsFor0Users() {
            //given
            CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
            List<String> resultListOfUsers = new ArrayList<>();
            int resultPostCount = 0;
            int resultCommentsCount = 0;
            when(statisticsMock.usersNames()).thenReturn(resultListOfUsers);
            when(statisticsMock.postsCount()).thenReturn(resultPostCount);
            when(statisticsMock.commentsCount()).thenReturn(resultCommentsCount);

            //when
            var map = calculateStatistics.calculateAdvStatistics(statisticsMock);
            double result1 = map.get("Number of users: ");
            double result2 = map.get("Number of posts: ");
            double result3 = map.get("Number of comments: ");
            double result4 = map.get("Number of users: ");
            double result5 = map.get("Number of users: ");
            double result6 = map.get("Number of posts: ");
            String showMap = calculateStatistics.showStatistics();

            //then
            assertEquals(0.0, result1);
            assertEquals(0.0, result2);
            assertEquals(0.0, result3);
            assertEquals(0.0, result4);
            assertEquals(0.0, result5);
            assertEquals(0.0, result6);
            System.out.println("Expected: 0.0; Result: " + result1);
            System.out.println("Expected: 0.0; Result: " + result2);
            System.out.println("Expected: 0.0; Result: " + result3);
            System.out.println("Expected: 0.0; Result: " + result4);
            System.out.println("Expected: 0.0; Result: " + result5);
            System.out.println("Expected: 0.0; Result: " + result6);
            System.out.println(showMap);
        }

        @Test
        void testCalculateAdvStatisticsFor10Users() {
            //given
            CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
            List<String> resultListOfUsers = generateListOfUsers(100);
            int resultPostCount = 100;
            int resultCommentsCount = 1000;
            when(statisticsMock.usersNames()).thenReturn(resultListOfUsers);
            when(statisticsMock.postsCount()).thenReturn(resultPostCount);
            when(statisticsMock.commentsCount()).thenReturn(resultCommentsCount);


            //when
            var map = calculateStatistics.calculateAdvStatistics(statisticsMock);
            double result1 = map.get("Number of users: ");
            double result2 = map.get("Number of posts: ");
            double result3 = map.get("Number of comments: ");
            double result4 = map.get("Average number of posts per user: ");
            double result5 = map.get("Average number of comments per user: ");
            double result6 = map.get("Average number of comments per post: ");
            String showMap = calculateStatistics.showStatistics();

            //then
            assertEquals(100.0, result1);
            assertEquals(100.0, result2);
            assertEquals(1000.0, result3);
            assertEquals(1.0, result4);
            assertEquals(10.0, result5);
            assertEquals(10.0, result6);
            System.out.println("Expected: 100.0; Result: " + result1);
            System.out.println("Expected: 100.0; Result: " + result2);
            System.out.println("Expected: 1000.0; Result: " + result3);
            System.out.println("Expected: 1.0; Result: " + result4);
            System.out.println("Expected: 10.0; Result: " + result5);
            System.out.println("Expected: 10.0; Result: " + result6);
            System.out.println(showMap);
        }
    }
}
