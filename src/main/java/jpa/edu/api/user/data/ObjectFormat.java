package jpa.edu.api.user.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ObjectFormat<T> {

    private T data;

}
