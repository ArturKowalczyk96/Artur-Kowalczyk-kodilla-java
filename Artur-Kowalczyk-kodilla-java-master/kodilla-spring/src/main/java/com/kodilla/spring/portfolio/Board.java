package com.kodilla.spring.portfolio;

public final class Board {

    public TaskList toDoList;
    public TaskList inProgressList;
    public TaskList doneList;

    public Board(final TaskList toDoList, final TaskList inProgressList, final TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }
}
