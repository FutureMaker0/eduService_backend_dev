package jpa.edu.api.task.controller;

import jpa.edu.api.task.data.dto.TaskDto;
import jpa.edu.api.task.data.dto.TaskDto2;
import jpa.edu.api.task.data.dto.TaskDto3;
import jpa.edu.api.task.data.request.CreateTaskRequestV1;
import jpa.edu.api.task.data.request.CreateTaskRequestV2;
import jpa.edu.api.task.data.response.CreateTaskResponse;
import jpa.edu.api.user.data.ObjectFormat;
import jpa.edu.domain.SubTask;
import jpa.edu.domain.Task;
import jpa.edu.domain.Team;
import jpa.edu.domain.user.User;
import jpa.edu.repository.SubTaskRepository;
import jpa.edu.repository.TeamRepository;
import jpa.edu.repository.UserRepository;
import jpa.edu.service.SubTaskService;
import jpa.edu.service.TaskService;
import jpa.edu.service.TeamService;
import jpa.edu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TaskApiController {

    private final TaskService taskService;

    private final SubTaskService subTaskService;
    private final SubTaskRepository subTaskRepository;

    private final TeamService teamService;
    private final TeamRepository teamRepository;

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/api/v1/tasks")
    public CreateTaskResponse createTaskV1(@RequestBody CreateTaskRequestV1 createTaskRequest) {
        Task task = new Task();
        task.setTitle(createTaskRequest.getTitle());
        task.setContent(createTaskRequest.getContent());
        task.setIsCompleted(createTaskRequest.getIsCompleted());
        Long id = taskService.createTask(task);

        return new CreateTaskResponse(id);
    }

    @GetMapping("/api/v1/tasks")
    public ObjectFormat tasks_v1() {
        List<Task> allTasks = taskService.findAllTasks();
        List<TaskDto> collect = allTasks.stream()
                .map(t -> new TaskDto(t))
                .collect(Collectors.toList());

        return new ObjectFormat(collect);
    }

    @GetMapping("/api/v2/tasks")
    public ObjectFormat tasks_v2() {
        List<Task> allTasks = taskService.findAllTasks();
        List<TaskDto2> collect = allTasks.stream()
                .map(t -> new TaskDto2(t))
                .collect(Collectors.toList());

        return new ObjectFormat(collect);
    }

    @GetMapping("/api/v3/tasks")
    public ObjectFormat tasks_v3() {
        List<Task> allTasks = taskService.findAllTasks();
        List<TaskDto3> collect = allTasks.stream()
                .map(t -> new TaskDto3(t))
                .collect(Collectors.toList());

        return new ObjectFormat(collect);
    }


}
