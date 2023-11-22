package com.example.cronparser.Interfaces;

import com.example.cronparser.models.ParsedResponse;

public interface IPostProcessing {
    ParsedResponse run(ParsedResponse parsedResponse);
}
