package com.housepredictionbackend.Rule.Service;

import com.housepredictionbackend.utilities.DataResult;
import org.json.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import java.io.IOException;

@Service
public class RuleServiceImpl implements RuleService{

    @Override
    public DataResult<Object> returnRules() throws IOException, ParseException {
        JSONParser jsonParser= new JSONParser() ;

        FileReader fileReader = new FileReader("src/main/resources/Rule.json");
        Object obj = jsonParser.parse(fileReader);

        return new DataResult<>(obj, true) ;
    }
}
