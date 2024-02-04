package com.garage.garageManager.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.garage.garageManager.utils.Constants;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "JOBCARD_DETAILS")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="JOBCARD_ID" )
    int jobCardId;

    @Column(name="CREATED_NAME")
    String createdBy;

    @Column(name = "JOBCARD_STATUS")
    String jobCardStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    @Column(name = "CREATED_DATE")
    LocalDateTime createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = Constants.ETA_DATE_TIME_FORMAT)
    @Column(name = "ETA_DATE")
    LocalDateTime estimateTimeOfArrivalDate;

}
