package com.product_management_system.product_management_system.Service;

import com.product_management_system.product_management_system.Entity.Product;
import com.product_management_system.product_management_system.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductBySerialNumber(String serialNumber) {
        return productRepository.findById(serialNumber);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String serialNumber) {
        productRepository.deleteById(serialNumber);
    }

    public boolean existsBySerialNumber(String serialNumber) {
        return productRepository.existsById(serialNumber);
    }
}