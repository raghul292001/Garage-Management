package com.garage.garageManager.controller;

import com.garage.garageManager.entity.JobCardEntity;
import com.garage.garageManager.service.JobCardEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/garageManagement")
public class GarageController {

    @Autowired
    JobCardEntityService jobCardEntityService;
    @PostMapping("/saveOrUpdate")
    public ResponseEntity<JobCardEntity> saveOrUpdate(@RequestBody JobCardEntity jobCardEntity){
        jobCardEntity = jobCardEntityService.saveOrUpdateJobCardDetails(jobCardEntity);
        return new ResponseEntity<>(jobCardEntity,HttpStatus.OK);
    }

    @GetMapping("/findAllJobcardDetails")
    public ResponseEntity<List<JobCardEntity>> findAllJobcardDetails(){
        List<JobCardEntity>jobCardEntities = jobCardEntityService.getAllJobCardEntity();
        return new ResponseEntity<>(jobCardEntities,HttpStatus.OK);
    }
}
