package jpa.edu.repository;

import jpa.edu.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCreateUser_UserId(Long userId);

}
