
import com.jaowadh.todolist.model.User;

public class Main {
    public static void main(String[] args) {
        User alice = new User("Alice");
        User bob   = new User("Bob");

        alice.addTask("Buy groceries");
        alice.addTask("Finish Java project");
        bob.addTask("Exercise");

        alice.markTaskCompleted(0);

        alice.printTasks();
        System.out.println();
        bob.printTasks();
    }
}

