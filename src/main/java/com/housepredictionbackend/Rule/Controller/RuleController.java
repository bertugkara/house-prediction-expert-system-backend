package com.housepredictionbackend.Rule.Controller;

import com.fasterxml.jackson.annotation.JsonValue;
import com.housepredictionbackend.Rule.Service.RuleService;
import com.housepredictionbackend.utilities.DataResult;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "api/rule")
public class RuleController {

    private final RuleService ruleService;

    @GetMapping("/getRules")
    public DataResult<Object> returnRules() throws IOException, ParseException {
        return ruleService.returnRules();

    }
}
