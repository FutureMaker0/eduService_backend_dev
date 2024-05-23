package jpa.edu.api.user.data.response;

import lombok.Data;

@Data
public class CreateUserResponse {

    private Long id;

    public CreateUserResponse(Long id) {
        this.id = id;
    }

}
