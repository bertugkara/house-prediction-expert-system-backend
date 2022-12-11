package com.housepredictionbackend.Exception.ExceptionHandlers;



import com.housepredictionbackend.utilities.ErrorResult;
import com.housepredictionbackend.utilities.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    public Result handleMethodArgumentException(RuntimeException exception) {
        return new ErrorResult(exception.getMessage());
    }

    @ExceptionHandler(value = {IOException.class})
    public Result handleMethodArgumentException(IOException exception) {
        return new ErrorResult(exception.getCause().getMessage());
    }

}
