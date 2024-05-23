package jpa.edu.api.subtask.data.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jpa.edu.domain.Status;
import jpa.edu.domain.SubTask;
import jpa.edu.domain.Team;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubTaskDto {

    @Enumerated(EnumType.STRING)
    private Status isCompleted;

    public SubTaskDto(SubTask subTask) {
        isCompleted = subTask.getIsCompleted();
    }

}
