package com.housepredictionbackend.Evaluate.Service;

import ai.catboost.CatBoostError;
import ai.catboost.CatBoostModel;
import ai.catboost.CatBoostPredictions;
import com.housepredictionbackend.AIModel.AIModel;
import com.housepredictionbackend.EvaluteEngine.EngineController;
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
        AIModel model=new AIModel(query);

        double result=model.getPrediction();
        System.out.println(result);
        pricePerMeterSquare=(int)evaluateRules(rules,query,result);
        System.out.println(pricePerMeterSquare);

        //pricePerMeterSquare=evaluate(rules,query);
        //Business Logic Kural Evaluate islemi

        //RETURN SONUC METREKAREBASINA DUSEN FIYAT

        return pricePerMeterSquare;
    }

    public double evaluateRules(JSONObject rules,Query query,double result) {



        EngineController engine=new EngineController();
        engine.putValues(query);
        engine.getEngine().put("result",result);
        result=processRules(engine, (JSONArray) ((JSONObject)rules.get("ruleBase")).get("child"));;
//        System.out.println(result);


        return result;
    }
    public double processRules(EngineController engine,JSONArray rules){

//        Integer result=0;
        for ( Object rule : rules) {
            System.out.println("girdi fonk");
            System.out.println(rule);
            //based on you key types
            JSONObject jsonObject=(JSONObject)rule;
            String ruleText= jsonObject.get("rule").toString();
            try {
                if((boolean) engine.getEngine().eval(ruleText)){
                    String gettedResult=(String) jsonObject.get("result");


                    if (gettedResult!=null) {
                        engine.getEngine().eval(gettedResult);
//                        Integer.parseInt(gettedResult);
//                        return result;
                    }
//                    else{
                        System.out.println("girdi recursice");
                        JSONArray jsonArray=(JSONArray) jsonObject.get("child");
                        if(!jsonArray.isEmpty()){
                            System.out.println("burda rule:"+ ruleText);
                            processRules(engine,jsonArray);
//                            if(result!=0){
//                                return result;
//                            }
                        }
//                    }

                }

                //Print key and value

            } catch (ScriptException e) {
                System.out.println(e);
                throw new RuntimeException(e);
            }

            //for nested objects iteration if required

        }

        return (double)engine.getEngine().get("result");
    }
}
