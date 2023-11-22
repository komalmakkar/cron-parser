package com.example.cronparser;

import com.example.cronparser.controller.HealthController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class CronParserApplicationTests {

    @Autowired
    private HealthController controller;

    @Test
    void contextLoads() {
        // to ensure that controller is getting created inside the application context
        assertNotNull(controller);
    }

}
