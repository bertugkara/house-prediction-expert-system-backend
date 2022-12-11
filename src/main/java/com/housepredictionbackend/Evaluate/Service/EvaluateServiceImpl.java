package com.housepredictionbackend.Evaluate.Service;

import com.housepredictionbackend.Query.Entity.Query;
import com.housepredictionbackend.Rule.Service.RuleService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EvaluateServiceImpl implements EvaluateService{

    private final RuleService ruleService;

    @Override
    public Integer evaluate(Query query) throws IOException, ParseException {
        Integer pricePerMeterSquare=null;

        //getir su anki kurallari
        Object rules = ruleService.returnRules();

        //Business Logic Kural Evaluate islemi



        //RETURN SONUC METREKAREBASINA DUSEN FIYAT
        return pricePerMeterSquare;
    }
}
