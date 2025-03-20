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
        var task = taskRepo.getById(id);

        return task.orElseThrow(() -> new NotFoundException("Task not found!"));
    }

    public Task createTask(Task taskToSave) {
        if (taskToSave == null) throw new BadRequestException("Task cannot be null!");

        validateTitle(taskToSave.getTitle());

        return taskRepo.save(taskToSave);
    }

    public void updateTask(int id, Task taskToUpdate) {
        taskRepo.update(id, taskToUpdate)
                .orElseThrow(() -> new NotFoundException("Task with provided ID does not exist!"));

    }

    public void deleteTask(int id) {
        taskRepo.delete(id);
    }


    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new BadRequestException("Title cannot be empty or blank");
        }
    }

}
