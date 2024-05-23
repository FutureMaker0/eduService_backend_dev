package jpa.edu.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jpa.edu.domain.SubTask;
import jpa.edu.domain.Team;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Data
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    private String username;
    private String pw;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    private Team team;

    @JsonIgnore
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
