package com.product_management_system.product_management_system.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_number")
    private Long orderNumber;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "enterprise_name", nullable = false)
    private String enterpriseName;

    @Column(name = "order_status", nullable = false)
    private String orderStatus; // "PENDING", "PROCESSING", "COMPLETED", "CANCELLED"

    @Column(name = "current_price_in_order", nullable = false)
    private BigDecimal currentPriceInOrder;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    // Constructors
    public Order() {}


    public Order(String productName, String enterpriseName, String orderStatus,
                 BigDecimal currentPriceInOrder, LocalDate orderDate) {
        this.productName = productName;
        this.enterpriseName = enterpriseName;
        this.orderStatus = orderStatus;
        this.currentPriceInOrder = currentPriceInOrder;
        this.orderDate = orderDate;
    }

    // Getters and Setters
    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getCurrentPriceInOrder() {
        return currentPriceInOrder;
    }

    public void setCurrentPriceInOrder(BigDecimal currentPriceInOrder) {
        this.currentPriceInOrder = currentPriceInOrder;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}