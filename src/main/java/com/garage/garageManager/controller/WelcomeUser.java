package com.garage.garageManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.scanner.Constant;

@RestController
public class WelcomeUser {


    @GetMapping("/appStatus")
    public String checkApplicationStatus(){
        return "yea it is running";
    }


}
