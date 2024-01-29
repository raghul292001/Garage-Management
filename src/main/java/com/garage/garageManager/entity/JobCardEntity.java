package com.garage.garageManager.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "JOBCARD_DETAILS")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="JOBCARD_ID" )
    int jobcardId;

    @Column(name="NAME")
    String name;

    @Column(name = "EMAIL_ID")
    String emailId;
}
