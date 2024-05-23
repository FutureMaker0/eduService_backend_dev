package jpa.edu.api.user.controller;

import jpa.edu.api.user.data.ObjectFormat;
import jpa.edu.domain.user.AdminUser;
import jpa.edu.domain.user.CommonUser;
import jpa.edu.service.UserService;
import jpa.edu.api.user.data.response.CreateUserResponse;
import jpa.edu.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/commonUsers")
    public CreateUserResponse createCommonUser(@RequestBody CommonUser commonUser) {
        Long id = userService.createUser(commonUser);
        return new CreateUserResponse(id);
    }

//    @GetMapping("/api/commonUsers")
//    public ObjectFormat commonUsers() {
//        return new ObjectFormat(userService.findAllUsers());
//    }

    @PostMapping("/api/adminUsers")
    public CreateUserResponse createAdminUser(@RequestBody AdminUser adminUser) {
        Long id = userService.createUser(adminUser);
        return new CreateUserResponse(id);
    }

    @GetMapping("/api/users")
    public ObjectFormat users() {
        return new ObjectFormat(userService.findAllUsers());
    }


}
