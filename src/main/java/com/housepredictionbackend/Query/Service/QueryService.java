package com.housepredictionbackend.Query.Service;

import com.housepredictionbackend.Query.Entity.Query;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface QueryService {

    Integer performQueryOperations(Query query) throws IOException, ParseException;
}
