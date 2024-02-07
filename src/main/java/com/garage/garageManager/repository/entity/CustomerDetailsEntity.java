package com.garage.garageManager.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "CUSTOMER_DETAILS")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    Long id;

    @ManyToOne
            @JoinColumn(name = "JOB_CARD_ID",nullable = false)
    JobCardEntity jobCardEntity;

    @Column(name = "CUSTOMER_NAME")
    String name;

    @Column(name = "EMAIL_ID")
    String emailId;

    @Column(name = "MOBILE_NUMBER")
    String mobileNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    Address address;

    @Data
    @Entity
    @Table(name = "address")
    @FieldDefaults(level = AccessLevel.PRIVATE)
    private static class Address {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        String street;

        String city;

        @Column(name = "zip_code")
        String zipCode;
    }
}
