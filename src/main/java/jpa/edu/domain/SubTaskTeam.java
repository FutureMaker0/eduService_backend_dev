package jpa.edu.domain;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.FetchType.*;

@Entity
@Data
public class SubTaskTeam {

    @Id
    @GeneratedValue
    @Column(name = "team_subtask_id")
    private Long tsId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "subtask_id")
    private SubTask subTask;

}
