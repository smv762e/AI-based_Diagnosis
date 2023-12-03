package com.backend_robots.backend_robot.controller;

import com.backend_robots.backend_robot.model.Admin;
import com.backend_robots.backend_robot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/admins/{id}")
    public Admin getAdminById(@PathVariable long id) {
        return adminService.getAdminById(id);
    }

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @PutMapping("/admins/{id}")
    public Admin updateAdmin(@PathVariable long id, @RequestBody Admin admin) {
        return adminService.updateAdmin(id, admin);
    }

    @DeleteMapping("/admins/{id}")
    public void deleteAdmin(@PathVariable long id) {
        adminService.deleteAdmin(id);
    }
}
