package com.housepredictionbackend.Query.Service;

import com.housepredictionbackend.Evaluate.Service.EvaluateService;
import com.housepredictionbackend.Query.Entity.Query;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class QueryServiceImpl implements QueryService{

    private final EvaluateService evaluateService;
    @Override
    public Integer performQueryOperations(Query query) throws IOException, ParseException {
        //query düzenlemeleri varsa yapilir. Query class'inin icine bakilabilir.

        Integer pricePerMeterSquare = evaluateService.evaluate(query);
        return multiplyMeterSquareAndPricePerMeterSquare(pricePerMeterSquare, query.getMeterSquare());
    }

    private Integer multiplyMeterSquareAndPricePerMeterSquare(Integer pricePerMeterSquare, Short meterSquareOfHouse){
        return (pricePerMeterSquare * meterSquareOfHouse);
    }
}
