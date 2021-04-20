package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Task {

    private final String taskName;
    private final String whatToByu;
    private final double quantity;

    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity){
        this.taskName = taskName;
        this.whatToByu = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public String executeTask() {
        return whatToByu + ": " + String.valueOf(quantity);
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return false;
    }
}
