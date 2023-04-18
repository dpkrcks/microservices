package com.dpkrcks.rating.service.RatingService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<Map<String , Object>> handlerResourceNotFoundException(ResourceNotFoundException ex){

         Map map = new HashMap();
         map.put("message" , ex.getMessage());
         map.put("success" , false);
         map.put("status" , HttpStatus.NOT_FOUND);

         return ResponseEntity.ok(map);
    }
}
