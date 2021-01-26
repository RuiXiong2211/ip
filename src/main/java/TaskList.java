import java.util.ArrayList;
import java.util.List;

public class TaskList {

    public ArrayList<Task> storage;

    public TaskList() {
        this.storage = new ArrayList<Task>();
    }

    void add(Task task) throws DukeException {
        storage.add(task);
        System.out.println("ALRIGHT. I HAVE ALREADY ADDED THE TASK");
        System.out.println(task);
        System.out.println("Now you have " + storage.size() + " tasks in the list.");
        System.out.println();
    }

    void done(int value) throws DukeException {
        if (value <= 0 || value > storage.size()) {
            throw new DukeException("No such list item.");
        }
        storage.get(value - 1).markAsDone();
        System.out.println("ALRIGHT. THIS TASK HAS BEEN MARKED AS COMPLETE");
        System.out.println(storage.get(value - 1));
        System.out.println();
    }

    /**
     * function that deletes en entry in the list
     */
    void delete(int value) throws DukeException {
        if (value <= 0 || value > storage.size()) {
            throw new DukeException("No such list item.");
        }
        System.out.println("OK. TASK REMOVED.");
        System.out.println(storage.get(value - 1));
        storage.remove(value - 1);
        System.out.println("Now you have " + storage.size() + " tasks in the list.");
        System.out.println();
    }

     void listItems() {
        if (storage.isEmpty()) {
            System.out.println("Empty list");
            System.out.println();
        } else {
            System.out.println("HERE ARE THE TASKS");
            for (int j = 0; j < storage.size(); j++) {
                System.out.println((j+1) + ". " + storage.get(j));
            }
            System.out.println();
        }
    }
}
