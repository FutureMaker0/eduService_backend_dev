package jpa.edu.api.task.data.request;

import jpa.edu.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTaskRequestV1 {

    private Long taskId;

    private String title;
    private String content;
    private Status isCompleted;

    public CreateTaskRequestV1() {

    }

}
