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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VEHICLE_ID")
    int id;

    @Column(name = "LICENSE_PLATE")
    int licensePlate;

    @Column(name = "CAR_NAME")
    String carName;

    @Column(name = "YEAR")
    int year;

}
