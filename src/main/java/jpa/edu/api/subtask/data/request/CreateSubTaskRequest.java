package jpa.edu.api.subtask.data.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jpa.edu.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreateSubTaskRequest {

    private Status isCompleted;
//    private LocalDate completedDate;
//    private LocalDateTime createdAt;
//    private LocalDateTime modifiedAt;

    public CreateSubTaskRequest() {
    }

}
