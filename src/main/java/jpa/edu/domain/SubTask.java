package jpa.edu.domain;

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

    @OneToMany(mappedBy = "subTask")
    private List<SubTaskTeam> teams = new ArrayList<>();

//    @ManyToMany(mappedBy = "user")
//    private List<User> users = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Status isCompleted;

    private LocalDate completedDate;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

}
