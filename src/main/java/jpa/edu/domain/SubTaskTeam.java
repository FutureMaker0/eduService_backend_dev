package jpa.edu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.FetchType.*;

@Entity
@Data
public class SubTaskTeam {

    @Id
    @GeneratedValue
    @Column(name = "team_subtask_id")
    private Long subTaskTeamId;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "subtask_id")
    private SubTask subTask;


    //== 생성 메서드 ==//
    public static SubTaskTeam createSubTaskTeam(Team team) {
        SubTaskTeam subTaskTeam = new SubTaskTeam();
        subTaskTeam.setTeam(team);

        return subTaskTeam;
    }

}
