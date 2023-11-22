package com.example.cronparser.Interfaces;

import com.example.cronparser.models.BadRequestException;

public interface IParserService {

    public String parse(String cronSyntax) throws BadRequestException;
}
