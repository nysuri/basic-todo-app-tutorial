package nl.hva.my_todo_app.repository;

import nl.hva.my_todo_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
