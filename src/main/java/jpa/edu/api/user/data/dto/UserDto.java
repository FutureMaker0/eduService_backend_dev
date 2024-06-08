package jpa.edu.api.user.data.dto;

import jpa.edu.domain.user.User;
import lombok.Data;

@Data
public class UserDto {

    private Long userId;
    private String userName;
    private String teamName;

    public UserDto(User user) {
        userId = user.getUserId();
        userName = user.getUsername();
        teamName = user.getTeam().getTeamName();
    }

}
