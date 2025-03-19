package nl.hva.my_todo_app.controller;

import nl.hva.my_todo_app.exception.BadRequestException;
import nl.hva.my_todo_app.exception.NotFoundException;
import nl.hva.my_todo_app.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final List<Task> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add(new Task("Do the groceries!"));
        tasks.add(new Task("Clean up my room"));
    }

    @GetMapping
    public List<Task> getTasks() {
        return tasks;
    }

    @GetMapping("{id}")
    public Task getTaskById(@PathVariable int id) {
        return tasks.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task with ID " + id + "Not found."));
    }

    @PostMapping
    public Task save(@RequestBody Task task) {
        tasks.add(task);
        return task;
    }

    @PutMapping("{id}")
    public Task update(@PathVariable int id, @RequestBody Task taskToUpdate) {

        if (id != taskToUpdate.getId()) {
            throw new BadRequestException("Malformed ID!");
        }

        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(taskToUpdate.getTitle());
                task.setCompleted(taskToUpdate.isCompleted());
                return taskToUpdate;
            }
        }

        throw new NotFoundException("Task not found!");
    }

    
}
