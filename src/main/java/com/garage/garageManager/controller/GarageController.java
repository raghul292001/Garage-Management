package com.garage.garageManager.controller;

import com.garage.garageManager.customResponse.ResponseHandler;
import com.garage.garageManager.entity.JobCardEntity;
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
    @PostMapping("/saveOrUpdate")
    public ResponseEntity<Object> saveOrUpdate(@RequestBody JobCardEntity jobCardEntity){
        jobCardEntity = jobCardEntityService.saveOrUpdateJobCardDetails(jobCardEntity);
        return ResponseHandler.responseBuilder("Job card created successfully",true,HttpStatus.OK,jobCardEntity);
    }

    @GetMapping("/findAllJobcardDetails")
    public ResponseEntity<Object> findAllJobcardDetails(){
        List<JobCardEntity>jobCardEntities = jobCardEntityService.getAllJobCardEntity();
        return ResponseHandler.responseBuilder("Job Card details fetched successfully",true,HttpStatus.OK,jobCardEntities);
    }
}
