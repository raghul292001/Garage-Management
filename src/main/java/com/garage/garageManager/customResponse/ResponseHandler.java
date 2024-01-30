package com.garage.garageManager.customResponse;

import com.garage.garageManager.entity.JobCardEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> responseBuilder(String message, boolean result, HttpStatus httpStatus,
                                                         Object jobCardEntity) {
        Map<String, Object> responceMap = new HashMap<>();
        responceMap.put("message", message);
        responceMap.put("result", result);
        responceMap.put("httpStatus", httpStatus);
        responceMap.put("data", jobCardEntity);
        return new ResponseEntity<Object>(responceMap,httpStatus);
    }
}
