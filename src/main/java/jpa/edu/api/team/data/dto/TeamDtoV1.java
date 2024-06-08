package jpa.edu.api.team.data.dto;

import jpa.edu.domain.Team;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamDtoV1 {

    private String teamName;

    public TeamDtoV1(Team team) {
        teamName = team.getTeamName();
    }

}
