package jpa.edu.api.team.data.dto;

import jpa.edu.api.task.data.dto.TaskDto3;
import jpa.edu.api.user.data.dto.UserDto;
import jpa.edu.domain.Team;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class TeamDtoV2 {

    private Long teamId;
    private String teamName;
//    private List<UserDto> users;
//    private List<TaskDto3> tasks;

    public TeamDtoV2(Team team) {
        teamId = team.getTeamId();
        teamName = team.getTeamName();
//        users = team.getUsers().stream()
//                .map(u -> new UserDto(u))
//                .collect(Collectors.toList());
//        tasks = team.getTasks().stream()
//                .map(t -> new TaskDto3(t))
//                .collect(Collectors.toList());
    }

}
