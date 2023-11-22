package com.example.cronparser.controller;

import com.example.cronparser.Interfaces.IParserService;
import com.example.cronparser.models.BadRequestException;
import com.example.cronparser.models.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CronParserController {

    @Autowired
    IParserService parserService;

    @PutMapping("/parse")
    public ResponseEntity<String> parser(@RequestBody CronExpression cronExpression) throws BadRequestException {
        return new ResponseEntity<String>(this.parserService.parse(cronExpression.getCronExpression()), HttpStatus.OK);
    }
}
