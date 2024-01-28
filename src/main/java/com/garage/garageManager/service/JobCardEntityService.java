package com.garage.garageManager.service;

import com.garage.garageManager.dao.JobCardEntityDao;
import com.garage.garageManager.entity.JobCardEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class JobCardEntityService {


    private final JobCardEntityDao jobCardEntityDao;
    public void saveOrUpdateJobCardDetails(JobCardEntity jobCardEntity){
        log.info("Inserting Job card details");
         jobCardEntityDao.save(jobCardEntity);
    }

    public List<JobCardEntity> getAllJobCardEntity(){
        log.info("Finding Job card details");
    return jobCardEntityDao.findAll();
    }
}
