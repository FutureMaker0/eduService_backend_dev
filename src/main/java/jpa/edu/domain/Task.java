package jpa.edu.domain;

import jakarta.persistence.*;
import jpa.edu.domain.user.User;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "task_id")
    private Long taskId;

    // task 생성 유저 데이터 필드
    @OneToOne(fetch = LAZY)
    private User createUser;

//    @OneToMany(mappedBy = "task")
//    private List<TaskUser> taskUsers;

    // task 생성 유저가 속한 팀 데이터 필드
    @OneToOne(fetch = LAZY)
    private Team userTeam;

    private String title;
    private String content;

    @Enumerated(EnumType.STRING)
    private Status isCompleted;

    private LocalDate completedDate;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "task")
    private List<SubTask> subTasks = new ArrayList<>();

}
