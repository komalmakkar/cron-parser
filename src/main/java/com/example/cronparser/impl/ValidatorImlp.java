package com.example.cronparser.impl;

import com.example.cronparser.Interfaces.IValidator;
import com.example.cronparser.constants.ErrorMessages;
import com.example.cronparser.models.BadRequestException;
import com.example.cronparser.models.UserInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ValidatorImlp implements IValidator {

    @Override
    public UserInput validate(String cronExpression) throws BadRequestException {
        String [] values = cronExpression.split(" ");
        if(values.length != 6) {
            throw new BadRequestException(ErrorMessages.InvalidInput_LessThanSixSegments);
        }
        UserInput userInput = new UserInput(
                values[0],
                values[1],
                values[2],
                values[3],
                values[4],
                values[5]
        );
        return userInput;
    }
}
