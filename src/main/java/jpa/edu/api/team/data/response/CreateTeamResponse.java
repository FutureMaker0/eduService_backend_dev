package jpa.edu.api.team.data.response;

import lombok.Data;

@Data
public class CreateTeamResponse {

    private Long id;

    public CreateTeamResponse(Long id) {
        this.id = id;
    }

}
