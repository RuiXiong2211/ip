import java.util.Scanner;

import static java.lang.System.exit;

public class Parser {

    Scanner sc;

    public Parser() {
        this.sc = new Scanner(System.in);
    }

    void readCommands(TaskList tasks, Storage fm) {
        String cmd = sc.next();
        while (true) {
            try {
                switch (cmd) {
                    case "bye":
                        fm.saveFile(tasks);
                        terminate();
                        break;
                    case "list":
                        tasks.listItems();
                        break;
                    case "todo":
                        tasks.add(new Todo(sc.nextLine()));
                        break;
                    case "deadline":
                        String rest = sc.nextLine();
                        String[] parts = rest.split("/by");
                        tasks.add(new Deadline(parts[0], parts[1]));
                        break;
                    case "event":
                        String rest1 = sc.nextLine();
                        String[] parts1 = rest1.split("/at");
                        tasks.add(new Event(parts1[0], parts1[1]));
                        break;
                    case "done":
                        int number = sc.nextInt();
                        tasks.done(number);
                        break;
                    case "delete":
                        int no = sc.nextInt();
                        tasks.delete(no);
                        break;
                    default:
                        break;
                }
            } catch (DukeException E) {
                //System.out.println("Caught DukeException.");
                System.out.println(E);
            }
            cmd = sc.next();
        }
    }

    void terminate() {
        System.out.println("GOOD BYE SEE YOU AGAIN!");
        System.out.println();
        sc.close();
        exit(0);
    }
}
