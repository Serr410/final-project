package com.product_management_system.product_management_system.Controller;

import com.product_management_system.product_management_system.Service.ProductService;
import com.product_management_system.product_management_system.Service.EnterpriseService;
import com.product_management_system.product_management_system.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String home(Model model) {
        try {
            long productsCount = productService.getAllProducts().size();
            long enterprisesCount = enterpriseService.getAllEnterprises().size();
            long ordersCount = orderService.getAllOrders().size();

            model.addAttribute("productsCount", productsCount);
            model.addAttribute("enterprisesCount", enterprisesCount);
            model.addAttribute("ordersCount", ordersCount);
        } catch (Exception e) {
            model.addAttribute("productsCount", 0);
            model.addAttribute("enterprisesCount", 0);
            model.addAttribute("ordersCount", 0);
        }
        return "static/index";
    }
}
