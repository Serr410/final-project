package com.product_management_system.product_management_system.Controller;

import com.product_management_system.product_management_system.Entity.Order;
import com.product_management_system.product_management_system.Service.OrderService;
import com.product_management_system.product_management_system.Service.ProductService;
import com.product_management_system.product_management_system.Service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();

        // Рассчитываем статистику
        long completedCount = orders.stream()
                .filter(order -> "COMPLETED".equals(order.getOrderStatus()))
                .count();

        long pendingCount = orders.stream()
                .filter(order -> "PENDING".equals(order.getOrderStatus()))
                .count();

        long cancelledCount = orders.stream()
                .filter(order -> "CANCELLED".equals(order.getOrderStatus()))
                .count();

        long processingCount = orders.stream()
                .filter(order -> "PROCESSING".equals(order.getOrderStatus()))
                .count();

        model.addAttribute("orders", orders);
        model.addAttribute("totalCount", orders.size());
        model.addAttribute("completedCount", completedCount);
        model.addAttribute("pendingCount", pendingCount);
        model.addAttribute("cancelledCount", cancelledCount);
        model.addAttribute("processingCount", processingCount);

        return "orders/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        Order order = new Order();
        order.setOrderDate(LocalDate.now()); // Устанавливаем текущую дату по умолчанию

        model.addAttribute("order", order);
        model.addAttribute("allProducts", productService.getAllProducts()); // все продукты
        model.addAttribute("allEnterprises", enterpriseService.getAllEnterprises()); // все предприятия
        return "orders/create";
    }

    @PostMapping
    public String createOrder(@ModelAttribute Order order,
                              @RequestParam String selectedProductName,
                              @RequestParam String selectedEnterpriseName) {

        // Устанавливаем выбранные значения
        order.setProductName(selectedProductName);
        order.setEnterpriseName(selectedEnterpriseName);

        // Устанавливаем дату, если не установлена
        if (order.getOrderDate() == null) {
            order.setOrderDate(LocalDate.now());
        }

        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Order order = orderService.getOrderById(id)
                .orElseThrow(() -> new IllegalArgumentException("Неверный номер заказа: " + id));

        model.addAttribute("order", order);
        model.addAttribute("allProducts", productService.getAllProducts());
        model.addAttribute("allEnterprises", enterpriseService.getAllEnterprises());
        return "orders/edit";
    }

    @PostMapping("/update/{id}")
    public String updateOrder(@PathVariable Long id,
                              @ModelAttribute Order order,
                              @RequestParam String selectedProductName,
                              @RequestParam String selectedEnterpriseName) {

        order.setOrderNumber(id);
        order.setProductName(selectedProductName);
        order.setEnterpriseName(selectedEnterpriseName);

        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }
}