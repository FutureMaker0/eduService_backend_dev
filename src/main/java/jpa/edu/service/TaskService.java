package jpa.edu.service;

import jpa.edu.api.task.data.dto.TaskDto;
import jpa.edu.domain.Task;
import jpa.edu.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    /**
     * Task 등록
     */
    @Transactional
    public Long createTask(Task task) {
        taskRepository.save(task);
        return task.getTaskId();
    }

    /**
     * Task 전체 조회
     */
    public List<Task> findAllTasks() {
        List<Task> allTasks = taskRepository.findAll();
        return allTasks;
    }

}
