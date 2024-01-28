package com.garage.garageManager.dao;

import com.garage.garageManager.entity.JobCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobCardEntityDao extends JpaRepository<JobCardEntity,Integer> {
}
