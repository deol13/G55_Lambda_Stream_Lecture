package se.lexicon;

public class Todo {
    private String title;
    private boolean isCompleted;
    private int priority;

    public Todo(String title, boolean isCompleted, int priority) {
        this.title = title;
        this.isCompleted = isCompleted;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task:{Title: " + title + ", isCompleted: " + isCompleted + ", Priority: " + priority + "}";
    }
}
