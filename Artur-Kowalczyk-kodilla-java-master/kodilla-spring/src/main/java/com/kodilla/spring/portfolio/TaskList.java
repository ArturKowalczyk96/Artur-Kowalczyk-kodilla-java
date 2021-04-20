package com.kodilla.spring.portfolio;

import java.util.*;

public final class TaskList {

    protected List<String> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public List<String> getTasks() {
        return tasks;
    }
}
