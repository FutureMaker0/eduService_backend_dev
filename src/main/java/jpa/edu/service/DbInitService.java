package jpa.edu.service;

import jakarta.persistence.EntityManager;
import jpa.edu.domain.*;
import jpa.edu.domain.user.AdminUser;
import jpa.edu.domain.user.CommonUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Transactional
@RequiredArgsConstructor
public class DbInitService {

    private final EntityManager em;

    public void dbInitialize() {

        Team team1 = createTeam("단비");
        em.persist(team1);
        Team team2 = createTeam("다래");
        em.persist(team2);
        Team team3 = createTeam("블라블라");
        em.persist(team3);
        Team team4 = createTeam("철로");
        em.persist(team4);
        Team team5 = createTeam("땅이");
        em.persist(team5);
        Team team6 = createTeam("해태");
        em.persist(team6);
        Team team7 = createTeam("수피");
        em.persist(team7);

        CommonUser commonUser1 = createCommonUser("commonUser1", "1234", team1, true);
        em.persist(commonUser1);
        CommonUser commonUser2 = createCommonUser("commonUser2", "1234", team2, true);
        em.persist(commonUser2);
        AdminUser adminUser = createAdminUser("adminUser1", "1234", team3, false);
        em.persist(adminUser);

        SubTaskTeam subTaskTeam1 = SubTaskTeam.createSubTaskTeam(team1);
        SubTaskTeam subTaskTeam2 = SubTaskTeam.createSubTaskTeam(team2);
        SubTaskTeam subTaskTeam3 = SubTaskTeam.createSubTaskTeam(team3);
        SubTaskTeam subTaskTeam4 = SubTaskTeam.createSubTaskTeam(team4);
        SubTaskTeam subTaskTeam5 = SubTaskTeam.createSubTaskTeam(team5);
        SubTaskTeam subTaskTeam6 = SubTaskTeam.createSubTaskTeam(team6);
        SubTaskTeam subTaskTeam7 = SubTaskTeam.createSubTaskTeam(team7);


        SubTask subTask1 = SubTask.createSubTask(Status.valueOf("FALSE"), LocalDate.now(), LocalDateTime.now(), LocalDateTime.now(), subTaskTeam1, subTaskTeam2);
        em.persist(subTask1);
        SubTask subTask2 = SubTask.createSubTask(Status.valueOf("FALSE"), LocalDate.now(), LocalDateTime.now(), LocalDateTime.now(), subTaskTeam3, subTaskTeam4);
        em.persist(subTask2);
        SubTask subTask3 = SubTask.createSubTask(Status.valueOf("FALSE"), LocalDate.now(), LocalDateTime.now(), LocalDateTime.now(), subTaskTeam5, subTaskTeam6);
        em.persist(subTask3);

        Task task1 = Task.createTask(commonUser1, team1, Status.valueOf("FALSE"), subTask1);
        em.persist(task1);
        Task task2 = Task.createTask(commonUser2, team2, Status.valueOf("TRUE"), subTask2, subTask3);
        em.persist(task2);

//        SubTask subTask3 = SubTask.createSubTask(Status.valueOf("FALSE"), LocalDate.now(), LocalDateTime.now(), LocalDateTime.now(), subTaskTeam2);
//        em.persist(subTask3);
//        SubTask subTask4 = SubTask.createSubTask(Status.valueOf("FALSE"), LocalDate.now(), LocalDateTime.now(), LocalDateTime.now(), subTaskTeam3);
//        em.persist(subTask4);
//        Task task2 = Task.createTask(commonUser2, team2, Status.valueOf("FALSE"), subTask2, subTask3);
//        em.persist(task2);
//
//        SubTask subTask5 = SubTask.createSubTask(Status.valueOf("FALSE"), LocalDate.now(), LocalDateTime.now(), LocalDateTime.now(), subTaskTeam1);
//        em.persist(subTask5);
//        SubTask subTask6 = SubTask.createSubTask(Status.valueOf("FALSE"), LocalDate.now(), LocalDateTime.now(), LocalDateTime.now(), subTaskTeam3);
//        em.persist(subTask6);
//        Task task3 = Task.createTask(adminUser, team3, Status.valueOf("FALSE"), subTask1, subTask3);
//        em.persist(task3);
    }


    private CommonUser createCommonUser(String username, String pw, Team team, Boolean isCommonUser) {
        CommonUser commonUser = new CommonUser();
        commonUser.setUsername(username);
        commonUser.setPw(pw);
        commonUser.setTeam(team);
        commonUser.setIsCommonUser(isCommonUser);
        return commonUser;
    }

    private AdminUser createAdminUser(String username, String pw, Team team, Boolean isCommonUser) {
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(username);
        adminUser.setPw(pw);
        adminUser.setTeam(team);
        adminUser.setIsCommonUser(isCommonUser);
        return adminUser;
    }

    private Team createTeam(String teamName) {
        Team team = new Team();
        team.setTeamName(teamName);
        return team;
    }


//     SubTaskTeam 엔티티에 존재
//    private SubTaskTeam createSubTaskTeam(Team team, SubTask subTask) {
//        SubTaskTeam subTaskTeam = new SubTaskTeam();
//        subTaskTeam.setTeam(team);
//        subTaskTeam.setSubTask(subTask);
//        return subTaskTeam;
//    }

// Task 엔티티에 존재
//    private static Task createTask(String title, String content, Status isCompleted) {
//        Task task = new Task();
//        task.setTitle(title);
//        task.setContent(content);
//        task.setIsCompleted(isCompleted);
//        return task;
//    }


}
