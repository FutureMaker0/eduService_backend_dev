package jpa.edu.api.user.controller;

import jpa.edu.api.user.data.ObjectFormat;
import jpa.edu.api.user.data.dto.UserDto;
import jpa.edu.api.user.data.dto.UserUpdateDto;
import jpa.edu.domain.user.AdminUser;
import jpa.edu.domain.user.CommonUser;
import jpa.edu.service.UserService;
import jpa.edu.api.user.data.response.CreateUserResponse;
import jpa.edu.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping("/api/v1/users")
    public ObjectFormat users_v1() {
        return new ObjectFormat(userService.findAllUsers());
    }

    @GetMapping("/api/v2/users")
    public ObjectFormat users_v2() {
        List<User> allUsers = userService.findAllUsers();
        List<UserDto> collect = allUsers.stream()
                .map(u -> new UserDto(u))
                .collect(Collectors.toList());

        return new ObjectFormat(collect);
    }

    @GetMapping("/api/users/{userId}")
    public ResponseEntity<UserDto> findUser_v1(@PathVariable("userId") Long userId) {
        Optional<User> findUser = userService.findById(userId);

//        if (findUser.isPresent()) {
//            User user = findUser.get();
//            return ResponseEntity.ok(new UserDto(user));
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }

        // lambda 표현식 refactoring
        return findUser.map(user -> ResponseEntity.ok(new UserDto(user)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/api/users/{userId}")
    public ResponseEntity<UserUpdateDto> updateUser(@PathVariable("userId") Long userId, @RequestBody UserUpdateDto userUpdateDto) {
        try {
            User updatedUser = userService.updateUser(userId, userUpdateDto);
            return ResponseEntity.ok(new UserUpdateDto(updatedUser));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

//    @DeleteMapping("/api/users/{userId}")
//    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId) {
//        userService.deleteUser(userId);
//        return ResponseEntity.noContent().build();
//    }

}
