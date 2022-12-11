package com.housepredictionbackend.JSON.Controller;

import com.housepredictionbackend.JSON.Service.JSONService;
import com.housepredictionbackend.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "api/json/")
public class JsonController {

    private final JSONService jsonService;

    @PostMapping("save")
    public Result save(@RequestBody Object saveJsonRequest) {
        return jsonService.saveJSON(saveJsonRequest);
    }

}
