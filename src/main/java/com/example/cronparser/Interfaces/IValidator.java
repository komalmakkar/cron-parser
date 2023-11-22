package com.example.cronparser.Interfaces;

import com.example.cronparser.models.BadRequestException;
import com.example.cronparser.models.UserInput;

public interface IValidator {
    public UserInput validate (String cronExpression) throws BadRequestException;
}
