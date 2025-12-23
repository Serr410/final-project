package com.product_management_system.product_management_system.Repository;

import com.product_management_system.product_management_system.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}