package com.garage.garageManager.repository.dao;

import com.garage.garageManager.repository.entity.JobCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobCardEntityDao extends JpaRepository<JobCardEntity,Long> {
}
