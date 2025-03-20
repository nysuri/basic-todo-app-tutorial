package nl.hva.my_todo_app.controller;

import nl.hva.my_todo_app.model.Task;
import nl.hva.my_todo_app.repository.TaskRepo;
import nl.hva.my_todo_app.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;


    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

    @GetMapping("{id}")
    public Task getTaskById(@PathVariable int id) {
        return this.service.getTaskById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task save(@RequestBody Task task) {
        return service.createTask(task);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Task taskToUpdate) {
        service.updateTask(id, taskToUpdate);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.deleteTask(id);
    }


}
