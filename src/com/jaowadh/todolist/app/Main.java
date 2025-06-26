package com.jaowadh.todolist.app;

import com.jaowadh.todolist.model.User;

import java.util.Scanner;

public class Main {
    private static final User[] users = new User[10];
    private static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== To-Do List Manager ===");
            System.out.println("1. Create user");
            System.out.println("2. Add task");
            System.out.println("3. Mark task completed");
            System.out.println("4. View tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> createUser(scanner);
                case 2 -> addTask(scanner);
                case 3 -> markCompleted(scanner);
                case 4 -> viewTasks(scanner);
                case 5 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void createUser(Scanner sc) {
        System.out.print("Enter new user name: ");
        String name = sc.nextLine().trim();
        if (getUser(name) != null) {
            System.out.println("User already exists.");
            return;
        }
        if (userCount >= users.length) {
            System.out.println("User limit reached.");
            return;
        }
        users[userCount++] = new User(name);
        System.out.println("Created user \"" + name + "\".");
    }

    private static void addTask(Scanner sc) {
        User user = promptForUser(sc);
        if (user == null) return;
        System.out.print("Enter task description: ");
        String desc = sc.nextLine().trim();
        user.addTask(desc);
        System.out.println("Added task to " + user.getName());
    }

    private static void markCompleted(Scanner sc) {
        User user = promptForUser(sc);
        if (user == null) return;
        System.out.print("Enter task index to mark complete: ");
        int idx = Integer.parseInt(sc.nextLine());
        user.markTaskCompleted(idx);
    }

    private static void viewTasks(Scanner sc) {
        User user = promptForUser(sc);
        if (user == null) return;
        user.printTasks();
    }

    private static User promptForUser(Scanner sc) {
        System.out.print("Enter user name: ");
        String name = sc.nextLine().trim();
        User u = getUser(name);
        if (u == null) System.out.println("User not found.");
        return u;
    }

    private static User getUser(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null;
    }
}


