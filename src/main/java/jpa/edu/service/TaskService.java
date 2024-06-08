package jpa.edu.service;

import jpa.edu.domain.SubTask;
import jpa.edu.domain.Task;
import jpa.edu.domain.Team;
import jpa.edu.domain.user.User;
import jpa.edu.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

//    public Long registTask(User user, Team team, List<SubTask> subTasks) {
//        Task task = new Task();
//        task.setCreateUser(user);
//        task.setUserTeam(team);
//
//        task.setCompletedDate(LocalDate.now());
//        task.setCreatedAt(LocalDateTime.now());
//        task.setModifiedAt(LocalDateTime.now());
//
//        for (SubTask subTask : subTasks) {
//            task.addSubTask(subTask);
//        }
//
//        return task.getTaskId();
//    }

}
