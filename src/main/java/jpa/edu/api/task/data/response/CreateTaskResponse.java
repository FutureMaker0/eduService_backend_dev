package jpa.edu.api.task.data.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jpa.edu.domain.Status;
import lombok.Data;

@Data
public class CreateTaskResponse {

    private Long taskId;

    public CreateTaskResponse(Long taskId) {
        this.taskId = taskId;
    }

}
