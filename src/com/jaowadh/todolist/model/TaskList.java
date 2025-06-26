package com.jaowadh.todolist.model;

public class TaskList {
    private TaskNode head;

    public void addTask(String description) {
        TaskNode node = new TaskNode(new Task(description));
        if (head == null) head = node;
        else {
            TaskNode cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
        }
    }

    public boolean markTaskCompleted(int index) {
        TaskNode cur = head; int i = 0;
        while (cur != null) {
            if (i++ == index) {
                cur.task.markCompleted();
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void printTasks() {
        TaskNode cur = head; int i = 0;
        while (cur != null) {
            System.out.println(i++ + ". " + cur.task);
            cur = cur.next;
        }
        if (i == 0) System.out.println("No tasks.");
    }
}
