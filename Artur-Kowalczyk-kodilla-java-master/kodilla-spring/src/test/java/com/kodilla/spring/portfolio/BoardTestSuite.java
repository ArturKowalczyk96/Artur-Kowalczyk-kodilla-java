package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    void testTaskAdd(){

        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.toDoList.getTasks().add("Clean the room.");
        board.inProgressList.getTasks().add("Pass threshold.");
        board.doneList.getTasks().add("Open door.");

        //Then
        System.out.println("To do list contains: " + board.toDoList.getTasks());
        System.out.println("In progress list contains: " + board.inProgressList.getTasks());
        System.out.println("Done list contains: " + board.doneList.getTasks());
    }
}
