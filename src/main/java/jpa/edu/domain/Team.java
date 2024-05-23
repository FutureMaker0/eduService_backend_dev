package jpa.edu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jpa.edu.domain.user.User;
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

//    @JsonIgnore
//    @OneToMany
//    private List<User> users;
//
//    @JsonIgnore
//    @OneToMany
//    private List<Task> tasks;

//    @OneToMany(mappedBy = "team")
//    private List<SubTaskTeam> subTaskTeams = new ArrayList<>();

}
