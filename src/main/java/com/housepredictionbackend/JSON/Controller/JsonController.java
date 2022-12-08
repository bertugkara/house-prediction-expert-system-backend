package com.housepredictionbackend.JSON.Controller;

import com.housepredictionbackend.utilities.DataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "api/json/")
public class JsonController {

    @PostMapping("save")
    public DataResult<Integer> save(@RequestParam MultipartFile file) {
        System.out.println(file);
        return null;
    }

}
