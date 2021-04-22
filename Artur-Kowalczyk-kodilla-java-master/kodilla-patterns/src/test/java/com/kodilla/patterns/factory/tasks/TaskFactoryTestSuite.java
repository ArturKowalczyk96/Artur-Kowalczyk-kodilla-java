package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPING_TASK);

        //Then
        assertEquals("Buy1", shoppingTask.getTaskName());
        assertEquals("Avocato: 1.0", shoppingTask.executeTask());
        assertEquals(false, shoppingTask.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task paintingTask = factory.makeTask(TaskFactory.PAINTING_TASK);

        //Then
        assertEquals("Paint1", paintingTask.getTaskName());
        assertEquals("kitchen in blue", paintingTask.executeTask());
        assertEquals(false, paintingTask.isTaskExecuted());
    }

    @Test
    void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task drivingTask = factory.makeTask(TaskFactory.DRIVING_TASK);

        //Then
        assertEquals("Drive1", drivingTask.getTaskName());
        assertEquals("To Home in: Mom's car", drivingTask.executeTask());
        assertEquals(false, drivingTask.isTaskExecuted());
    }
}
