package com.housepredictionbackend.Query.Controller;

import com.housepredictionbackend.Query.DTO.QueryRequest;
import com.housepredictionbackend.Query.Mapper.QueryMapper;
import com.housepredictionbackend.Query.Service.QueryService;
import com.housepredictionbackend.utilities.DataResult;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "api/query/")
public class QueryController {

    private final QueryService queryService;

    @PostMapping("receiveQuery")
    public DataResult<Integer> query(@RequestBody @Valid QueryRequest queryRequest) throws IOException, ParseException {
        System.out.println(queryRequest);
        return new DataResult<>(queryService.performQueryOperations
                (QueryMapper.INSTANCE.dtoToEntity(queryRequest)),
                true, "Operation Completed");
    }
}
