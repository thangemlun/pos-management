package com.thienday.posmanagement.controller;

import com.thienday.posmanagement.response.DataResponse;
import org.springframework.http.ResponseEntity;

import java.util.function.Function;

public class BaseController {

    public <R> ResponseEntity<?> execute(Function<R,?> service, String message){
        try{
            return ResponseEntity.ok(DataResponse.apiResult(service.apply(null)
                    ,message));
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(DataResponse.apiError(e.getMessage()));
        }
    }
}
