package com.example.tacos.controllers;

import com.example.tacos.services.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminOrderService adminService;

    @Autowired
    public AdminController(AdminOrderService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public String showAdminPage() {
        return "admin";
    }

    @PostMapping
    public String deleteAllOrders() {
        adminService.deleteAllOrders();
        return "redirect:/admin";
    }

}
