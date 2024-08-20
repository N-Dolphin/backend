package org.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")  // 'test' 프로파일을 활성화합니다.

class BackendApplicationTests {

    @Test
    void contextLoads() {
    }

}
