package jpa.edu.service;

import jpa.edu.domain.user.User;
import jpa.edu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


}
