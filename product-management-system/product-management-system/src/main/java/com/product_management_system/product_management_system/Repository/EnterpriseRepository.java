package com.product_management_system.product_management_system.Repository;

import com.product_management_system.product_management_system.Entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, String> {
}