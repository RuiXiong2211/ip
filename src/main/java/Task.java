public class Task {

    protected String description;
    protected boolean isDone;
    protected char type;

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
        this.type = 0;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.type = 0;
    }

    public String getStatusIcon() {
        return (isDone? "\u2713" : "\u2718");
    }

    public boolean getStatus() {
        return this.isDone;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public char getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public String getData() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
}
