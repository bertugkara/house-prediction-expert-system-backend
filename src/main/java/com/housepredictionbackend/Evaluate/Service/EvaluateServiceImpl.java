package com.housepredictionbackend.Evaluate.Service;

import ai.catboost.CatBoostError;
import ai.catboost.CatBoostModel;
import ai.catboost.CatBoostPredictions;
import com.housepredictionbackend.Query.Entity.Query;
import com.housepredictionbackend.Rule.Service.RuleService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EvaluateServiceImpl implements EvaluateService{

    private final RuleService ruleService;

    @Override
    public Integer evaluate(Query query) throws IOException, ParseException {
        Integer pricePerMeterSquare=null;

        //getir su anki kurallari
        JSONObject rules = (JSONObject) ruleService.returnRules().getData();
        System.out.println(query);
        try {
            CatBoostModel model = CatBoostModel.loadModel("src/main/resources/model.cbm");
            float [] floatFeatures={query.getTotalRoomNumber(),query.getAge(),query.getBathroomNumber(),
            toInt(query.getNorth()),toInt(query.getSouth()),toInt(query.getEast()),toInt(query.getWest())};
            String [] strArr={query.getNeighbourhood(),query.getDistrict(),query.getFloor(),query.getIsFurnished()};
            CatBoostPredictions prediction=model.predict(floatFeatures,strArr);
            System.out.println(prediction.get(0,0));

        } catch (CatBoostError e) {
            throw new RuntimeException(e);
        }
        //pricePerMeterSquare=evaluate(rules,query);
        //Business Logic Kural Evaluate islemi



        //RETURN SONUC METREKAREBASINA DUSEN FIYAT
        return pricePerMeterSquare;
    }
    private int toInt(boolean bool ){
        return (bool) ? 1 : 0;
    }
    public int evaluate(JSONObject rules,Query query) {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("graal.js");
        engine.put("neighbourhood",query.getNeighbourhood());
        engine.put("totalRoomNumber",query.getTotalRoomNumber());
        engine.put("meterSquare",query.getMeterSquare());
        engine.put("floor",query.getFloor());
        engine.put("age",query.getAge());
        engine.put("bathroomNumber",query.getBathroomNumber());
        engine.put("isFurnished",query.getIsFurnished());
        engine.put("west",query.getWest());
        engine.put("north",query.getNorth());
        engine.put("south",query.getSouth());
        engine.put("east",query.getEast());
        System.out.println("resukt");
        Integer result=processRules(engine, (JSONArray) ((JSONObject)rules.get("ruleBase")).get("child"));



        return result;
    }
    public int processRules(ScriptEngine engine,JSONArray rules){

        Integer result=0;
        for ( Object rule : rules) {
            System.out.println("girdi fonk");
            System.out.println(rule);
            //based on you key types
            JSONObject jsonObject=(JSONObject)rule;
            String ruleText= jsonObject.get("rule").toString();
            try {
                if((boolean) engine.eval(ruleText)){
                    String gettedResult=(String) jsonObject.get("result");


                    if (gettedResult!=null) {
                        result=Integer.parseInt(gettedResult);
                        return result;
                    }
                    else{
                        System.out.println("girdi recursice");
                        JSONArray jsonArray=(JSONArray) jsonObject.get("child");
                        if(!jsonArray.isEmpty()){
                            System.out.println("burda rule:"+ ruleText);
                            result=processRules(engine,jsonArray);
                            if(result!=0){
                                return result;
                            }
                        }
                    }

                }

                //Print key and value

            } catch (ScriptException e) {
                throw new RuntimeException(e);
            }

            //for nested objects iteration if required

        }

        return result;
    }
}
