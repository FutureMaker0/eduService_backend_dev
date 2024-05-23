package jpa.edu.api.team.data.dto;

import jpa.edu.domain.Team;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamDto {

    private String teamName;

    public TeamDto(Team team) {
        teamName = team.getTeamName();
    }

}
