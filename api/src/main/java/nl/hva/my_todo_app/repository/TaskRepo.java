package nl.hva.my_todo_app.repository;

import nl.hva.my_todo_app.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepo {
    private static int generatedId = 0;
    private final List<Task> tasks = new ArrayList<>();

    public TaskRepo() {
        var task1 = new Task("Do the groceries!");
        this.save(task1);

        var task2 = new Task("Clean up my room.");
        this.save(task2);

    }

    public List<Task> findAll() {
        return tasks;
    }

    public Optional<Task> getById(int id) {
        return tasks.stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }

    public Task save(Task task) {
        task.setId(++generatedId); // automatically increment id on creation.
        tasks.add(task);
        return task; // created task
    }

    public Optional<Task> update(int id, Task task) {
        Optional<Task> foundTask = tasks.stream()
                .filter(x -> x.getId() == id)
                .findFirst();

        foundTask.ifPresent(taskToUpdate -> {
            taskToUpdate.setTitle(task.getTitle());
            taskToUpdate.setCompleted(task.isCompleted());
        });

        return foundTask;
    }

    public boolean delete(int id) {
        return tasks.removeIf(x -> x.getId() == id);
    }
}
