package com.example.cronparser.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;


import com.example.cronparser.Interfaces.IParserService;
import com.example.cronparser.models.BadRequestException;
import com.example.cronparser.models.CronExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class CronParserControllerTest {

    @Mock
    IParserService parserService;
    @InjectMocks
    CronParserController controller;
    @BeforeEach
    void init() {
        initMocks(this);
    }

    @Test
    void testParser_ValidCronExpression_ReturnsOkResponse() throws BadRequestException {
        // Arrange
        CronExpression cronExpression = new CronExpression();
        cronExpression.setCronExpression("0 0 * * * /komakkar");
        String expectedResponse = "Parsed cron expression";

        when(parserService.parse(cronExpression.getCronExpression())).thenReturn(expectedResponse);

        // Act
        ResponseEntity<String> response = controller.parser(cronExpression);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        verify(parserService, times(1)).parse(cronExpression.getCronExpression());
    }

}
