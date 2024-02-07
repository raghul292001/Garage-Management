package com.garage.garageManager.controller;

import com.garage.garageManager.business.GarageBusiness;
import com.garage.garageManager.utils.ResponseHandler;
import com.garage.garageManager.repository.entity.JobCardEntity;
import com.garage.garageManager.service.JobCardEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/garageManagement")
public class GarageController {

    @Autowired
    JobCardEntityService jobCardEntityService;
    @Autowired
    GarageBusiness garageBusiness;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity<Object> saveOrUpdate(@RequestBody String requestJson) {
        try {
            garageBusiness.saveJobCardDetails(requestJson);
            //jobCardEntity = jobCardEntityService.saveOrUpdateJobCardDetails(jobCardEntity);
            return ResponseHandler.responseBuilder("Job card created successfully", true, HttpStatus.OK, "");
        } catch (Exception exception) {
            return ResponseHandler.responseBuilder("Job card created Failed", true, HttpStatus.EXPECTATION_FAILED, exception.getMessage());
        }
    }

    @GetMapping("/findAllJobcardDetails")
    public ResponseEntity<Object> findAllJobcardDetails() {
        List<JobCardEntity> jobCardEntities = jobCardEntityService.getAllJobCardEntity();
        return ResponseHandler.responseBuilder("Job Card details fetched successfully", true, HttpStatus.OK, jobCardEntities);
    }
}
