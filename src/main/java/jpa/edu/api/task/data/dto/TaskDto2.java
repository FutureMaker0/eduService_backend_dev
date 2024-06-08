package jpa.edu.api.task.data.dto;

import jpa.edu.domain.Status;
import jpa.edu.domain.SubTask;
import jpa.edu.domain.Task;
import jpa.edu.domain.Team;
import jpa.edu.domain.user.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class TaskDto2 {

    private Long taskId;
    private Long userId;
    private String teamName;
    private Status isCompleted;
    private List<SubTask> subTasks;

    public TaskDto2(Task task) {
        taskId = task.getTaskId();
        userId = task.getCreateUser().getUserId();
        teamName = task.getUserTeam().getTeamName();
        isCompleted = task.getIsCompleted();
        subTasks = task.getSubTasks().stream()
                .map(st -> st)
                .collect(Collectors.toList());
    }

}
