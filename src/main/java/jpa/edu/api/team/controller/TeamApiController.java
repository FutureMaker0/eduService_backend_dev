package jpa.edu.api.team.controller;

import jpa.edu.api.team.data.dto.TeamDtoV1;
import jpa.edu.api.team.data.dto.TeamDtoV2;
import jpa.edu.api.team.data.request.CreateTeamRequest;
import jpa.edu.api.team.data.response.CreateTeamResponse;
import jpa.edu.api.user.data.ObjectFormat;
import jpa.edu.domain.Team;
import jpa.edu.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TeamApiController {

    private final TeamService teamService;

//    @PostMapping("/api/teams")
//    public CreateTeamResponse createTeam(@RequestBody Team team) {
//        Long id = teamService.createTeam(team);
//
//        return new CreateTeamResponse(id);
//    }

    @PostMapping("/api/teams")
    public CreateTeamResponse createTeam(@RequestBody CreateTeamRequest createTeamRequest) {
        Team team = new Team();
        team.setTeamName(createTeamRequest.getTeamName());
        Long id = teamService.createTeam(team);

        return new CreateTeamResponse(id);
    }

    @GetMapping("/api/v1/teams")
    public ObjectFormat teams_v1() {
        List<Team> allTeams = teamService.findAllTeams();
        List<TeamDtoV1> collect = allTeams.stream()
                .map(t -> new TeamDtoV1(t))
                .collect(Collectors.toList());

        return new ObjectFormat(collect);
    }

    @GetMapping("/api/v2/teams")
    public ObjectFormat teams_v2() {
        List<Team> allTeams = teamService.findAllTeams();
        List<TeamDtoV2> collect = allTeams.stream()
                .map(t -> new TeamDtoV2(t))
                .collect(Collectors.toList());

        return new ObjectFormat(collect);
    }

}
