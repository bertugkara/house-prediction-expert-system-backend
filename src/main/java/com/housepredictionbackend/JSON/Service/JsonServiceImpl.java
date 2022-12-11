package com.housepredictionbackend.JSON.Service;

import com.housepredictionbackend.utilities.Result;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class JsonServiceImpl implements JSONService{
    @Override
    public Result saveJSON(Object request) {

        org.json.simple.JSONObject obj = new JSONObject();
        obj.put("ruleBase", request);
        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/Rule.json");
            fileWriter.write(obj.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
