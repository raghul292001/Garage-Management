package com.garage.garageManager.repository.dao;

import com.garage.garageManager.repository.entity.CustomerDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsDao extends JpaRepository<CustomerDetailsEntity,Integer> {
}
