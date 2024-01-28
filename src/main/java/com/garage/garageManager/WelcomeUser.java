package com.garage.garageManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.scanner.Constant;

@Controller
@RestController
public class WelcomeUser {


    @GetMapping("/appStatus")
    public String checkApplicationStatus(){
        return "yes it is running";
    }

}
