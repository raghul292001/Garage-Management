package com.garage.garageManager.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.garage.garageManager.repository.dao.CustomerDetailsDao;
import com.garage.garageManager.repository.entity.CustomerDetailsEntity;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDetailsService {
    @Autowired
    CustomerDetailsDao customerDetailsDao;

    private CustomerDetailsEntity customerDetailsEntity = new CustomerDetailsEntity();

    public void saveCustomerDetails(String customerDetailsJsonString) {
        try {
            customerDetailsEntity = jsonToObjectMapperCustomerDetailsEntity(customerDetailsJsonString);
            customerDetailsDao.save(customerDetailsEntity);
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }

    public CustomerDetailsEntity saveOrUpdate(CustomerDetailsEntity customerDetailsJsonString){
        return customerDetailsDao.save(customerDetailsJsonString);
    }

    public List<CustomerDetailsEntity> getAllCustomerDetails(){
        log.info("Finding Job card details");
        return customerDetailsDao.findAll();
    }

    private CustomerDetailsEntity jsonToObjectMapperCustomerDetailsEntity(String jsonSting ){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            customerDetailsEntity = objectMapper.readValue(jsonSting,CustomerDetailsEntity.class);
        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return customerDetailsEntity;
    }

}
