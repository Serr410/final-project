package com.product_management_system.product_management_system.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "enterprises")
public class Enterprise {

    @Id
    @Column(name = "serial_number", unique = true, nullable = false)
    private String serialNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "director_name", nullable = false)
    private String directorName;

    // Constructors
    public Enterprise() {}

    public Enterprise(String serialNumber, String name, String directorName) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.directorName = directorName;
    }

    // Getters and Setters
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}