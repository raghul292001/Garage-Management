package com.garage.garageManager.utils;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> responseBuilder(String message, boolean result, HttpStatus httpStatus,
                                                         Object response) {
        Map<String, Object> responceMap = new HashMap<>();
        responceMap.put("message", message);
        responceMap.put("result", result);
        responceMap.put("httpStatus", httpStatus);
        if (response != null && !response.equals(""))
            responceMap.put("response", response);
        return new ResponseEntity<Object>(responceMap, httpStatus);
    }
}
