package jpa.edu.service;

import jpa.edu.api.user.data.dto.UserUpdateDto;
import jpa.edu.domain.user.User;
import jpa.edu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 회원 등록
     */
    @Transactional
    public Long createUser(User user) {
//        user.setPw(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user.getUserId();
    }

    /**
     * 전체 회원 조회
     */
    public List<User> findAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    /**
     * 개인 회원 조회
     */
    public Optional<User> findById(Long userId) {
        Optional<User> findUser = userRepository.findById(userId);
        return findUser;
    }

    /**
     * 개인 회원 수정
     */
    @Transactional
    public User updateUser(Long userId, UserUpdateDto userUpdateDto) {
        Optional<User> OptionalUser = userRepository.findById(userId);
        if (OptionalUser.isPresent()) {
            User presentUser = OptionalUser.get();
            presentUser.setUsername(userUpdateDto.getUserName());
            presentUser.setPw(userUpdateDto.getPw());

            return userRepository.save(presentUser);
        } else {
            throw new NoSuchElementException("User not found");
        }
    }

//    /**
//     * 회원 삭제
//     */
//    @Transactional
//    public void deleteUser(Long userId) {
//        List<Task> relatedTasks = taskRepository.findByCreateUser_UserId(userId);
//        for (Task relatedTask : relatedTasks) {
//            taskRepository.delete(relatedTask);
//        }
//        userRepository.deleteById(userId);
//    }

}
