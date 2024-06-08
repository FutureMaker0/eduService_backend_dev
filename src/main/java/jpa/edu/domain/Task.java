package jpa.edu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    // task 생성 유저 데이터 필드
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    private User createUser;

//    @OneToMany(mappedBy = "task")
//    private List<TaskUser> taskUsers;

    @JsonIgnore
    // task 생성 유저가 속한 팀 데이터 필드
    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    private Team userTeam;

    private String title;
    private String content;

    @Enumerated(EnumType.STRING)
    private Status isCompleted;

    private LocalDate completedDate;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<SubTask> subTasks = new ArrayList<>();


    //== 연관 관계 메서드 ==//
    public void addTaskUser(User user) {
        this.createUser = user;
    }

    public void syncTeam(Team team) {
        this.userTeam = team;
        team.getTasks().add(this);
    }

    public void addSubTask(SubTask subTask) {
        subTasks.add(subTask);
        subTask.setTask(this);
    }


    // 생성 메서드
    public static Task createTask(User user, Team team, Status isCompleted, SubTask... subTasks) {
        Task task = new Task();
        task.setCreateUser(user);
        task.setUserTeam(team);
        task.setIsCompleted(isCompleted);

        task.setCompletedDate(LocalDate.now());
        task.setCreatedAt(LocalDateTime.now());
        task.setModifiedAt(LocalDateTime.now());

        for (SubTask subTask : subTasks) {
            task.addSubTask(subTask);
        }


        return task;
    }


}
