package jpa.edu;

import jakarta.annotation.PostConstruct;
import jpa.edu.service.DbInitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DbInitializer {

    private final DbInitService dbInitService;

    @PostConstruct
    public void init() {
        dbInitService.dbInitialize();
    }

}
