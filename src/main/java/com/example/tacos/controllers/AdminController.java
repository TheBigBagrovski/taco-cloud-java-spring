package com.example.tacos.controllers;

import com.example.tacos.services.AdminService;
import com.example.tacos.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
@ConfigurationProperties(prefix = "taco.orders")
public class AdminController {

    private final AdminService adminService;
    private final OrderService orderService;

    private int pageSize = 20;

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Autowired
    public AdminController(AdminService adminService, OrderService orderService) {
        this.adminService = adminService;
        this.orderService = orderService;
    }

    @GetMapping("/delete-orders")
    public String deleteAllOrders() {
        adminService.deleteAllOrders();
        return "redirect:/admin";
    }

    @GetMapping("/show/{page}")
    public String ordersForClient(@PathVariable("page") int page,
                                  Principal principal, Model model) {
        model.addAttribute("orderList", orderService.findTacoOrdersByClientOrderByPlacedAtDesc(principal.getName(), page, pageSize));
        return "/admin";
    }

}
