package jpa.edu.api.task.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CreateTaskRequestV2 {

    private Long taskId;
    private Long userId;
    private Long teamId;
    private List<Long> subTaskIds;

    public CreateTaskRequestV2() {
    }

}
