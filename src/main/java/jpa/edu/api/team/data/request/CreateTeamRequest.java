package jpa.edu.api.team.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTeamRequest {

    private String teamName;

    public CreateTeamRequest() {
    }

}
