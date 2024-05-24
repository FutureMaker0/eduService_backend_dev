package jpa.edu.api.task.data.dto;

import jpa.edu.domain.Status;
import jpa.edu.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskDto {

    private String title;
    private String content;
    private Status isCompleted;

    public TaskDto(Task task) {
        title = task.getTitle();
        content = task.getContent();
        isCompleted = task.getIsCompleted();
    }

}
