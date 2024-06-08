package jpa.edu.api.subtask.data.dto;

import jpa.edu.api.team.data.dto.TeamDtoV2;
import jpa.edu.domain.Status;
import jpa.edu.domain.SubTask;
import jpa.edu.domain.SubTaskTeam;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class SubTaskDto {

    private Long subTaskId;
    private LocalDate completeDate;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Status isCompleted;
    private List<SubTaskTeamDto> teams;

    public SubTaskDto(SubTask subTask) {
        subTaskId = subTask.getSubTaskId();
        completeDate = subTask.getCompletedDate();
        createdAt = subTask.getCreatedAt();
        modifiedAt = subTask.getModifiedAt();
        isCompleted = subTask.getIsCompleted();
        teams = subTask.getTeams().stream()
                .map(t -> new SubTaskTeamDto(t))
                .collect(Collectors.toList());
    }

}
