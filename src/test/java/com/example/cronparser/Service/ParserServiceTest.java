
package com.example.cronparser.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.example.cronparser.Interfaces.IExpandExpression;
import com.example.cronparser.Interfaces.IPostProcessing;
import com.example.cronparser.Interfaces.IValidator;
import com.example.cronparser.models.BadRequestException;
import com.example.cronparser.models.ParsedResponse;
import com.example.cronparser.models.UserInput;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;


class ParserServiceTest {

    @Mock
    IValidator validator;

    @Mock
    IExpandExpression expandExpression;

    @Mock
    IPostProcessing postProcessing;
    @InjectMocks
    private ParserService parserServiceUnderTest;

    @BeforeEach
    void init() {
        initMocks(this);
    }


    @Test
    void testParse_ValidInput_ReturnsParsedResponse() throws BadRequestException {
        // Arrange
        String cronSyntax = "* * * * * /komalmakkar";
        UserInput mockedUserInput = new UserInput("*", "*" ,"*", "*", "*", "/komalmakkar");
        ParsedResponse mockedParsedResponse = new ParsedResponse();

        // Mock the dependencies
        when(validator.validate(cronSyntax)).thenReturn(mockedUserInput);
        when(expandExpression.run(mockedUserInput)).thenReturn(mockedParsedResponse);
        when(postProcessing.run(mockedParsedResponse)).thenReturn(mockedParsedResponse);

        // Act
        String result = parserServiceUnderTest.parse(cronSyntax);

        // Assert
        assertEquals(mockedParsedResponse.toString(), result);
        verify(validator).validate(cronSyntax);
        verify(expandExpression).run(mockedUserInput);
        verify(postProcessing).run(mockedParsedResponse);
    }

}
