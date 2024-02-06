package com.garage.garageManager.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.garage.garageManager.utils.Constants;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "SERVICE_DETAILS")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SERVICE_ID")
    int id;

    @Column(name = "TYPE")
    String type;

    @Column(name = "SERVICE_PRICE")
    int price;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    @Column(name = "DATE_TIME")
    LocalDateTime dateTime;


}
