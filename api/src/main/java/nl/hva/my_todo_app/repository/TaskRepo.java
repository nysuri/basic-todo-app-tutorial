package nl.hva.my_todo_app.repository;

import nl.hva.my_todo_app.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepo {
    private static int generatedId = 0;
    private final List<Task> tasks = new ArrayList<>();

    public TaskRepo() {
        tasks.add(new Task("Do the groceries!"));
        tasks.add(new Task("Clean up my room"));
    }

    public List<Task> getAll() {
        return tasks;
    }

    public Task getById(int id) {
        return tasks.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Task save(Task task) {
        task.setId(++generatedId); // automatically increment id on creation.
        tasks.add(task);
        return task; // created task
    }

    public Task update(int id, Task task) {
        var foundTask = tasks.stream().filter(x->x.getId() == id)
                .findFirst()
                .orElse(null);

        if (foundTask == null) return null;

        task.setTitle(foundTask.getTitle());
        task.setCompleted(task.isCompleted());
        return task;
    }

    public void delete(int id) {
        tasks.removeIf(x -> x.getId() == id);
    }


}
