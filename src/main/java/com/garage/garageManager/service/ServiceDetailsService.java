package com.garage.garageManager.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.garage.garageManager.repository.dao.ServiceDetailsDao;
import com.garage.garageManager.repository.entity.ServiceDetailsEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceDetailsService {
    @Autowired
    ServiceDetailsDao serviceDetailsDao;
    private ServiceDetailsEntity serviceDetailsEntity = new ServiceDetailsEntity();
    public void saveServiceDetails(String serviceDetailsJsonString){
        serviceDetailsEntity = jsonToObjectMapperServiceDetailsEntity(serviceDetailsJsonString);
        serviceDetailsDao.save(serviceDetailsEntity);
    }

    private ServiceDetailsEntity jsonToObjectMapperServiceDetailsEntity(String jsonSting ){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try{
            serviceDetailsEntity = objectMapper.readValue(jsonSting, ServiceDetailsEntity.class);
        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return serviceDetailsEntity;
    }
}
