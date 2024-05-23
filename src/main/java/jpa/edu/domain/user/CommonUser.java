package jpa.edu.domain.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("C")
public class CommonUser extends User{

    private Boolean isCommonUser = true;

}
