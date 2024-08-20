package org.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes= BackendApplicationTests.class)
@ActiveProfiles("test")
class BackendApplicationTests {

    @Test
    void contextLoads() {
    }

}
