package jpa.edu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Data
public class SubTask {

    @Id
    @GeneratedValue
    @Column(name = "subtask_id")
    private Long subTaskId;

    @OneToMany(mappedBy = "subTask", cascade = CascadeType.ALL)
    private List<SubTaskTeam> teams = new ArrayList<>();

//    @ManyToMany(mappedBy = "user")
//    private List<User> users = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Status isCompleted;

    private LocalDate completedDate;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @JsonIgnore
    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Task task;


    //== 연관 메서드 ==//
    public void addSubTaskTeam(SubTaskTeam subTaskTeam) {
        teams.add(subTaskTeam);
        subTaskTeam.setSubTask(this);
    }

    public static SubTask createSubTask(Status isCompleted,
                                        LocalDate completedDate,
                                        LocalDateTime createdAt,
                                        LocalDateTime modifiedAt,
                                        SubTaskTeam... subTaskTeams) {
        SubTask subTask = new SubTask();
        subTask.setCompletedDate(completedDate);
        subTask.setCreatedAt(createdAt);
        subTask.setModifiedAt(modifiedAt);
        subTask.setIsCompleted(isCompleted);

        for (SubTaskTeam subTaskTeam : subTaskTeams) {
            subTask.addSubTaskTeam(subTaskTeam);
        }

        return subTask;
    }

}
