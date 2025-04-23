package nl.hva.my_todo_app.config;

import nl.hva.my_todo_app.model.Task;
import nl.hva.my_todo_app.model.User;
import nl.hva.my_todo_app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbInitializer implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");

        var task1 = new Task("Do the groceries");
        var task2 = new Task("Clean the house");
        task1.setUser(user);
        task2.setUser(user);
        user.setTasks(List.of(task1, task2));

        userRepo.save(user);
    }
}
