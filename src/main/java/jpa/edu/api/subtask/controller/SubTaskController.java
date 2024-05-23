package jpa.edu.api.subtask.controller;

import jpa.edu.api.subtask.data.dto.SubTaskDto;
import jpa.edu.api.subtask.data.request.CreateSubTaskRequest;
import jpa.edu.api.subtask.data.response.CreateSubTaskResponse;
import jpa.edu.api.user.data.ObjectFormat;
import jpa.edu.domain.SubTask;
import jpa.edu.service.SubTaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SubTaskController {

    private final SubTaskService subTaskService;

    @PostMapping("/api/subTasks")
    public CreateSubTaskResponse createSubTask(@RequestBody CreateSubTaskRequest createSubTaskRequest) {
        SubTask subTask = new SubTask();
        subTask.setIsCompleted(createSubTaskRequest.getIsCompleted());
        Long id = subTaskService.createSubTask(subTask);
        log.info("subTask = {}", subTask);

        return new CreateSubTaskResponse(id);
    }

    @GetMapping("/api/subTasks")
    public ObjectFormat subTasks() {
        List<SubTask> allSubTasks = subTaskService.findAllSubTasks();
        log.info("allSubTasks = {}", allSubTasks);
        List<SubTaskDto> collect = allSubTasks.stream()
                .map(st -> new SubTaskDto(st))
                .collect(Collectors.toList());
        log.info("collect = {}", collect);

        return new ObjectFormat(collect);
    }


}
