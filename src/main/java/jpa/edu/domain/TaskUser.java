package jpa.edu.domain;

import jakarta.persistence.*;
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

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
