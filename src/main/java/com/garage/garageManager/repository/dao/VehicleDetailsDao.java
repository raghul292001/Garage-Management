package com.garage.garageManager.repository.dao;

import com.garage.garageManager.repository.entity.VehicleDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDetailsDao extends JpaRepository<VehicleDetailsEntity,Long> {
}
