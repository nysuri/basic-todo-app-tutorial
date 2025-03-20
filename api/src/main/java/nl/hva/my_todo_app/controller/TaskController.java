package nl.hva.my_todo_app.controller;

import nl.hva.my_todo_app.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return ResponseEntity.ok(task);
            }
        }

       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PostMapping
    public Task save(@RequestBody Task task) {
        tasks.add(task);
        return task;
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> update(@PathVariable int id, @RequestBody Task taskToUpdate) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(taskToUpdate.getTitle());
                task.setCompleted(taskToUpdate.isCompleted());
                return ResponseEntity.accepted().body(taskToUpdate);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    
}
