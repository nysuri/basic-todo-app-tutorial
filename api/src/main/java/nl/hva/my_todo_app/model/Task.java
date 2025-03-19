package nl.hva.my_todo_app.model;

public class Task {
    public static int GENERATED_ID = 0;
    private int id;
    private String title;
    private boolean completed;

    public Task(String title) {
        this.id = ++GENERATED_ID;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
