package com.garage.garageManager.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "CUSTOMER_DETAILS")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    int id;

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
    public static class Address {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String street;
        private String city;

        @Column(name = "zip_code")
        private String zipCode;
    }
}
