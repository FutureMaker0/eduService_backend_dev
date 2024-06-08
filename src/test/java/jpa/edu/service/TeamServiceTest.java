package jpa.edu.service;

import jpa.edu.domain.Team;
import jpa.edu.repository.TeamRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = true)
public class TeamServiceTest {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    TeamService teamService;

    @Test
    public void 테스트_팀생성() throws Exception {
        //given
        Team team = new Team();
        team.setTeamName("testName1");

        //when
        Long teamId = teamService.createTeam(team);

        //then
        assertEquals(team.getTeamId(), teamId);
    }

    @Test
    public void 테스트_팀조회() throws  Exception {
        //given //when
        List<Team> allTeams = teamService.findAllTeams();

        //then
        assertEquals("전체 팀 갯수", 7, allTeams.size());
    }

}