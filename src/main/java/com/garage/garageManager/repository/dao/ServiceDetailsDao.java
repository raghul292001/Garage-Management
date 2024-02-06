package com.garage.garageManager.repository.dao;


import com.garage.garageManager.repository.entity.ServiceDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDetailsDao extends JpaRepository<ServiceDetailsEntity,Integer> {
    }
