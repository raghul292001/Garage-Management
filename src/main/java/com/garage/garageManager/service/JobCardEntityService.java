package com.garage.garageManager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.garage.garageManager.repository.dao.JobCardEntityDao;
import com.garage.garageManager.repository.entity.JobCardEntity;
import com.garage.garageManager.repository.entity.ServiceDetailsEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class JobCardEntityService {

    @Autowired
    JobCardEntityDao jobCardEntityDao;

    private JobCardEntity jobCardEntity = new JobCardEntity();

    public JobCardEntity saveOrUpdateJobCardDetails(JobCardEntity jobCardEntity) {
        log.info("Inserting Job card details");
        return jobCardEntityDao.save(jobCardEntity);
    }

    public List<JobCardEntity> getAllJobCardEntity() {
        log.info("Finding Job card details");
        return jobCardEntityDao.findAll();
    }


    public void saveJobCardDetails(String jobCardDetailsJsonString) {
        jobCardEntity = jsonToObjectMapperServiceDetailsEntity(jobCardDetailsJsonString);
        jobCardEntityDao.save(jobCardEntity);
    }


    private JobCardEntity jsonToObjectMapperServiceDetailsEntity(String jsonSting) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            jobCardEntity = objectMapper.readValue(jsonSting, JobCardEntity.class);
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
        return jobCardEntity;
    }
}
