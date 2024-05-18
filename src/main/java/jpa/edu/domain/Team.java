package jpa.edu.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long teamId;
    private String teamName;

    @OneToMany
    private List<User> users;

    @OneToMany
    private List<Task> tasks;

    @OneToMany(mappedBy = "team")
    private List<SubTaskTeam> teamSubTasks = new ArrayList<>();

}
