package jpa.edu.api.subtask.data.response;

import lombok.Data;

@Data
public class CreateSubTaskResponse {

    private Long subTaskId;

    public CreateSubTaskResponse(Long subTaskId) {
        this.subTaskId = subTaskId;
    }

}
