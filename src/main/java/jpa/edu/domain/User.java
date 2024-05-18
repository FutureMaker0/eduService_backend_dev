package jpa.edu.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Data
@Table(name = "users")
public abstract class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    private String userName;
    private String pw;

    @ManyToOne(fetch = LAZY)
    private Team team;

    @ManyToMany
    @JoinTable(name = "user_subtask",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subtask_id"))
    private List<SubTask> subTasks = new ArrayList<>();

    // user가 생성하는 것은 맞지만, 어떤 task를 생성했는지는
    // 굳이 표기하지 않아도 될 듯 하다.
//    @ManyToOne(fetch = LAZY)
//    private Task task;

}
