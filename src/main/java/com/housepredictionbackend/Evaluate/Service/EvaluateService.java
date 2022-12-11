package com.housepredictionbackend.Evaluate.Service;

import com.housepredictionbackend.Query.Entity.Query;
import com.housepredictionbackend.utilities.Result;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface EvaluateService {
    Integer evaluate(Query query) throws IOException, ParseException;
}
