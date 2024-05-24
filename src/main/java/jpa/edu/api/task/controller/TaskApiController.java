package jpa.edu.api.task.controller;

import jpa.edu.api.task.data.dto.TaskDto;
import jpa.edu.api.task.data.request.CreateTaskRequest;
import jpa.edu.api.task.data.response.CreateTaskResponse;
import jpa.edu.api.user.data.ObjectFormat;
import jpa.edu.domain.Task;
import jpa.edu.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TaskApiController {

    private final TaskService taskService;

    @PostMapping("/api/tasks")
    public CreateTaskResponse createTask(@RequestBody CreateTaskRequest createTaskRequest) {
        Task task = new Task();
        task.setTitle(createTaskRequest.getTitle());
        task.setContent(createTaskRequest.getContent());
        task.setIsCompleted(createTaskRequest.getIsCompleted());
        Long id = taskService.createTask(task);

        return new CreateTaskResponse(id);
    }

    @GetMapping("/api/tasks")
    public ObjectFormat tasks() {
        List<Task> allTasks = taskService.findAllTasks();
        List<TaskDto> collect = allTasks.stream()
                .map(t -> new TaskDto(t))
                .collect(Collectors.toList());

        return new ObjectFormat(collect);
    }

}
