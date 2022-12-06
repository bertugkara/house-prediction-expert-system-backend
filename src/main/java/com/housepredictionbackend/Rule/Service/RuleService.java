package com.housepredictionbackend.Rule.Service;

import com.housepredictionbackend.utilities.DataResult;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface RuleService {

    DataResult<Object> returnRules() throws IOException, ParseException;
}
