package nl.hva.my_todo_app.repository;

import nl.hva.my_todo_app.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

    List<Task> findByCompleted(boolean completed);

    List<Task> findByTitleStartingWithIgnoreCase(String prefix);

    boolean existsByTitle(String title);
}
