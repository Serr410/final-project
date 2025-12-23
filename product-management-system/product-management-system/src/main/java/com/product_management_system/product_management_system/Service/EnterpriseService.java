package com.product_management_system.product_management_system.Service;

import com.product_management_system.product_management_system.Entity.Enterprise;
import com.product_management_system.product_management_system.Repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public List<Enterprise> getAllEnterprises() {
        return enterpriseRepository.findAll();
    }

    public Optional<Enterprise> getEnterpriseBySerialNumber(String serialNumber) {
        return enterpriseRepository.findById(serialNumber);
    }

    public Enterprise saveEnterprise(Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }

    public void deleteEnterprise(String serialNumber) {
        enterpriseRepository.deleteById(serialNumber);
    }

    public boolean existsBySerialNumber(String serialNumber) {
        return enterpriseRepository.existsById(serialNumber);
    }
}