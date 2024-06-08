package jpa.edu.api.subtask.data.dto;

import jpa.edu.api.team.data.dto.TeamDtoV2;
import jpa.edu.domain.SubTaskTeam;
import lombok.Data;

import java.util.List;

@Data
public class SubTaskTeamDto {

    private Long teamId;
    private String teamName;

    public SubTaskTeamDto(SubTaskTeam subTaskTeam) {
        teamId = subTaskTeam.getSubTaskTeamId();
        teamName = subTaskTeam.getTeam().getTeamName();
    }

}
