package jpa.edu.repository;

import jpa.edu.domain.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
