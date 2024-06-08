package jpa.edu.service;

import jpa.edu.domain.user.AdminUser;
import jpa.edu.domain.user.CommonUser;
import jpa.edu.domain.user.User;
import jpa.edu.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = true)
public class UserServiceTest {

    @Autowired UserRepository userRepository;
    @Autowired UserService userService;

    @Test
    public void 테스트_회원등록() {
        //given
        CommonUser commonUser = new CommonUser();
        commonUser.setUsername("common1");

        //when
        Long registedId = userService.createUser(commonUser);

        //then
        Assertions.assertEquals(commonUser.getUserId(), registedId);
    }

    @Test
    public void 테스트_회원조회() {
        //given
        CommonUser commonUser1 = new CommonUser();
        commonUser1.setUsername("common1");
        CommonUser commonUser2 = new CommonUser();
        commonUser2.setUsername("common2");
        AdminUser adminUser1 = new AdminUser();
        adminUser1.setUsername("admin1");

        //when
        userService.createUser(commonUser1);
        userService.createUser(commonUser2);
        userService.createUser(adminUser1);

        //then
        List<User> allUsers = userRepository.findAll();
        assertThat(allUsers).hasSize(6);
    }

}