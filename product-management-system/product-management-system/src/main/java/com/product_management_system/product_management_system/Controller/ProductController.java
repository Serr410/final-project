package com.product_management_system.product_management_system.Controller;

import com.product_management_system.product_management_system.Entity.Product;
import com.product_management_system.product_management_system.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/create";
    }

    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{serialNumber}")
    public String showEditForm(@PathVariable String serialNumber, Model model) {
        productService.getProductBySerialNumber(serialNumber).ifPresent(product -> {
            model.addAttribute("product", product);
        });
        return "products/edit";
    }

    @PostMapping("/update/{serialNumber}")
    public String updateProduct(@PathVariable String serialNumber,
                                @ModelAttribute Product product) {
        product.setSerialNumber(serialNumber);
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{serialNumber}")
    public String deleteProduct(@PathVariable String serialNumber) {
        productService.deleteProduct(serialNumber);
        return "redirect:/products";
    }
}