package com.example.cronparser.Service;

import com.example.cronparser.Interfaces.IExpandExpression;
import com.example.cronparser.Interfaces.IParserService;
import com.example.cronparser.Interfaces.IPostProcessing;
import com.example.cronparser.Interfaces.IValidator;
import com.example.cronparser.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@Primary
public class ParserService implements IParserService {

    @Autowired
    IValidator validator;

    @Autowired
    IExpandExpression expandExpression;

    @Autowired
    IPostProcessing postProcessing;

    @Override
    public String parse(String cronSyntax) throws BadRequestException {
        log.info("Starting the parsing");
        log.info("Validating");
        UserInput userInput = validator.validate(cronSyntax);
        log.info("Validated");
        log.info(userInput.toString());
        log.info("Expanding to parsed response");
        ParsedResponse parsedResponse = expandExpression.run(userInput);
        log.info(parsedResponse.toString());
        log.info("Expanded to parsed response");
        log.info("Post Processing starting");
        parsedResponse = postProcessing.run(parsedResponse);
        log.info("Post processing done.");
        return parsedResponse.toString();
    }

}
