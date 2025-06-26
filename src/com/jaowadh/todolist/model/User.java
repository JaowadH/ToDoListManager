package com.jaowadh.todolist.model;

public class User {
    private String name;
    private TaskList tasks = new TaskList();

    public User(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void addTask(String desc) {
        tasks.addTask(desc);
    }

    public void markTaskCompleted(int idx) {
        if (!tasks.markTaskCompleted(idx)) {
            System.out.println("Invalid task index for " + name);
        }
    }

    public void printTasks() {
        System.out.println("Tasks for " + name + ":");
        tasks.printTasks();
    }
}
