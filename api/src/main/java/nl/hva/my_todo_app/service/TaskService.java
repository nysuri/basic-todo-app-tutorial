package nl.hva.my_todo_app.service;

import nl.hva.my_todo_app.exception.BadRequestException;
import nl.hva.my_todo_app.exception.NotFoundException;
import nl.hva.my_todo_app.model.Task;
import nl.hva.my_todo_app.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Task getTaskById(int id) {
        return taskRepo.findById(id).orElseThrow(() -> new NotFoundException("Task not found!"));
    }

    public Task createTask(Task taskToSave) {
        if (taskToSave == null) throw new BadRequestException("Task cannot be null!");

        validateTitle(taskToSave.getTitle());

        if (taskRepo.existsByTitle(taskToSave.getTitle())) {
            throw new IllegalArgumentException("Title should be unique!");
        }
        return taskRepo.save(taskToSave);
    }

    public void updateTask(int id, Task taskToUpdate) {
        if (id != (taskToUpdate.getId()))
            throw new IllegalArgumentException("Given id is not equal to task id");

        if (taskRepo.existsByTitle(taskToUpdate.getTitle()))
            throw new RuntimeException("Title should be unique!");

        taskRepo.findById(id)
                .map(foundTask -> {
                    foundTask.setTitle(taskToUpdate.getTitle());
                    foundTask.setCompleted(taskToUpdate.isCompleted());
                    return taskRepo.save(foundTask);
                })
                .orElseThrow(() -> new NotFoundException("Task not found with ID: " + id));
    }

    public void deleteTask(int id) {
        taskRepo.deleteById(id);
    }

    public List<Task> getCompletedTasks() {
        return taskRepo.findByCompleted(true);
    }

    public List<Task> getTasksStartingWith(String prefix) {
        return taskRepo.findByTitleStartingWithIgnoreCase(prefix);
    }


    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new BadRequestException("Title cannot be empty or blank");
        }
    }

}
