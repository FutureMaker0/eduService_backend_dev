package jpa.edu.service;

import jpa.edu.api.user.data.ObjectFormat;
import jpa.edu.domain.Team;
import jpa.edu.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    /**
     * 팀 등록
     */
    @Transactional
    public Long createTeam(Team team) {
        teamRepository.save(team);
        return team.getTeamId();
    }

    /**
     * 전체 팀 조회
     */
    public List<Team> findAllTeams() {
        List<Team> allTeams = teamRepository.findAll();
        return allTeams;
    }



}
