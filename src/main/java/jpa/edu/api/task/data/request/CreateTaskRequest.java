package jpa.edu.api.task.data.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jpa.edu.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class CreateTaskRequest {

    private String title;
    private String content;
    private Status isCompleted;

    public CreateTaskRequest() {

    }

}
