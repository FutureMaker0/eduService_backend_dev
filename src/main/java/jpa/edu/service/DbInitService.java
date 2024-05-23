package jpa.edu.service;

import jakarta.persistence.EntityManager;
import jpa.edu.domain.user.AdminUser;
import jpa.edu.domain.user.CommonUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class DbInitService {

    private final EntityManager em;

    public void dbInitialize() {

        CommonUser commonUser1 = createCommonUser("commonUser1", "1234", true);
        em.persist(commonUser1);

        CommonUser commonUser2 = createCommonUser("commonUser2", "1234", true);
        em.persist(commonUser2);

        AdminUser adminUser = createAdminUser("adminUser1", "1234", false);
        em.persist(adminUser);
    }

    private CommonUser createCommonUser(String username, String pw, Boolean isCommonUser) {
        CommonUser commonUser = new CommonUser();
        commonUser.setUsername(username);
        commonUser.setPw(pw);
        commonUser.setIsCommonUser(isCommonUser);
        return commonUser;
    }

    private AdminUser createAdminUser(String username, String pw, Boolean isCommonUser) {
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(username);
        adminUser.setPw(pw);
        adminUser.setIsCommonUser(isCommonUser);
        return adminUser;
    }

}
