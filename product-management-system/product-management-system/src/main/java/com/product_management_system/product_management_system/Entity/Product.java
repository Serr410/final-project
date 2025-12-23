package com.product_management_system.product_management_system.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "serial_number", unique = true, nullable = false)
    private String serialNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "current_price", nullable = false)
    private BigDecimal currentPrice;

    @Column(name = "stock_status", nullable = false)
    private String stockStatus; // "IN_STOCK", "OUT_OF_STOCK", "LOW_STOCK"

    // Constructors
    public Product() {}

    public Product(String serialNumber, String name, BigDecimal currentPrice, String stockStatus) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.currentPrice = currentPrice;
        this.stockStatus = stockStatus;
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

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }
}