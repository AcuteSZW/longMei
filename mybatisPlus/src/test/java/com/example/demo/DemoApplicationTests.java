package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@MapperScan("com/example/demo/mbpDemo/dao/UserMapper")
@SpringBootTest
class DemoApplicationTests {
    @Test
    void contextLoads() {
    }

}
