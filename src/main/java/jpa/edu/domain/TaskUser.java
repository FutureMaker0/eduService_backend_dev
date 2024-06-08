package jpa.edu.domain;

import jakarta.persistence.*;
import jpa.edu.domain.user.User;
import lombok.Data;

import static jakarta.persistence.FetchType.*;

@Entity
@Data
@Table(name = "task_user")
public class TaskUser {

    @Id
    @GeneratedValue
    @Column(name = "task_user_id")
    private Long tuId;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
