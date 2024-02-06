package com.garage.garageManager.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.garage.garageManager.repository.dao.VehicleDetailsDao;
import com.garage.garageManager.repository.entity.VehicleDetailsEntity;
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
public class VehicleDetailsService {

    @Autowired
    VehicleDetailsDao vehicleDetailsDao;

    private VehicleDetailsEntity vehicleDetailsEntity = new VehicleDetailsEntity();

    public void saveVehicleDetails(String vehicleDetailsJsonString){
        vehicleDetailsEntity= jsonToObjectMapperVehicleDetailsEntity(vehicleDetailsJsonString);
        vehicleDetailsDao.save(vehicleDetailsEntity);
    }

    private VehicleDetailsEntity jsonToObjectMapperVehicleDetailsEntity(String jsonSting ){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            vehicleDetailsEntity = objectMapper.readValue(jsonSting,VehicleDetailsEntity.class);
        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return vehicleDetailsEntity;
    }
}
