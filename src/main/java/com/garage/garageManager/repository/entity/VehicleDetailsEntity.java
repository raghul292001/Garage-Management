package com.garage.garageManager.repository.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "VEHICLE_DETAILS")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VehicleDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VEHICLE_ID")
    int id;

    @ManyToOne
    @JoinColumn(name = "JOB_CARD_ID",nullable = false)
    JobCardEntity jobCardEntity;

    @Column(name = "LICENSE_PLATE")
    String licensePlate;

    @Column(name = "CAR_NAME")
    String carName;

    @Column(name = "YEAR")
    int year;

    @Column(name = "CAR_TYPE")
    String carType;



}
