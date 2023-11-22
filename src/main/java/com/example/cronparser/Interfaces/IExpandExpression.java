package com.example.cronparser.Interfaces;

import com.example.cronparser.models.ParsedResponse;
import com.example.cronparser.models.UserInput;

public interface IExpandExpression {
    public ParsedResponse run(UserInput userInput);
}
