package com.product_management_system.product_management_system.Controller;

import com.product_management_system.product_management_system.Entity.Enterprise;
import com.product_management_system.product_management_system.Service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/enterprises")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping
    public String getAllEnterprises(Model model) {
        model.addAttribute("enterprises", enterpriseService.getAllEnterprises());
        return "enterprises/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("enterprise", new Enterprise());
        return "enterprises/create";
    }

    @PostMapping
    public String createEnterprise(@ModelAttribute Enterprise enterprise) {
        enterpriseService.saveEnterprise(enterprise);
        return "redirect:/enterprises";
    }

    @GetMapping("/edit/{serialNumber}")
    public String showEditForm(@PathVariable String serialNumber, Model model) {
        enterpriseService.getEnterpriseBySerialNumber(serialNumber).ifPresent(enterprise -> {
            model.addAttribute("enterprise", enterprise);
        });
        return "enterprises/edit";
    }

    @PostMapping("/update/{serialNumber}")
    public String updateEnterprise(@PathVariable String serialNumber,
                                   @ModelAttribute Enterprise enterprise) {
        enterprise.setSerialNumber(serialNumber);
        enterpriseService.saveEnterprise(enterprise);
        return "redirect:/enterprises";
    }

    @GetMapping("/delete/{serialNumber}")
    public String deleteEnterprise(@PathVariable String serialNumber) {
        enterpriseService.deleteEnterprise(serialNumber);
        return "redirect:/enterprises";
    }
}