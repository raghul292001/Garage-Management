package com.garage.garageManager.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.garage.garageManager.utils.Constants;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="JOBCARD_ID" )
    Long jobCardId;

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

    @Column(name = "CUSTOMER_NOTES")
    String customerNotes;

    @Column(name = "FEEDBACK")
    String feedback;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    Employees employees;



    @Data
    @Entity
    @Table(name = "EMPLOYEE_DETAILS")
    @FieldDefaults(level = AccessLevel.PRIVATE)
    private static class Employees{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        String employeeName;

        String role;

    }

}
