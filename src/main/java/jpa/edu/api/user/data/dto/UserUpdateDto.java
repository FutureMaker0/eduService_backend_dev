package jpa.edu.api.user.data.dto;

import jpa.edu.domain.user.User;
import lombok.Data;

@Data
public class UserUpdateDto {

    private String userName;
    private String pw;

    public UserUpdateDto() {
    }

    public UserUpdateDto(User user) {
        userName = user.getUsername();
        pw = user.getPw();
    }

}
