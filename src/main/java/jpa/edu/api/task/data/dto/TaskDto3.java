package jpa.edu.api.task.data.dto;

import jpa.edu.api.subtask.data.dto.SubTaskDto;
import jpa.edu.api.subtask.data.dto.SubTaskTeamDto;
import jpa.edu.domain.Status;
import jpa.edu.domain.SubTask;
import jpa.edu.domain.SubTaskTeam;
import jpa.edu.domain.Task;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class TaskDto3 {

    private Long taskId;
    private String createUserName;
    private String userTeam;
    private Status isCompleted;
    private List<SubTaskDto> subTasks;

    public TaskDto3(Task task) {
        taskId = task.getTaskId();
        createUserName = task.getCreateUser().getUsername();
        userTeam = task.getUserTeam().getTeamName();
        isCompleted = task.getIsCompleted();
        subTasks = task.getSubTasks().stream()
                .map(st -> new SubTaskDto(st))
                .collect(Collectors.toList());
    }

}
