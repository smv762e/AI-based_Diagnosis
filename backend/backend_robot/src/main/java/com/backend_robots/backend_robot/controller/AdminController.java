package com.backend_robots.backend_robot.controller;

import com.backend_robots.backend_robot.model.Admin;
import com.backend_robots.backend_robot.model.Routes;
import com.backend_robots.backend_robot.service.AdminService;
import com.backend_robots.backend_robot.service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService, RoutesService routesService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id)
                .orElse(null); // Manejar el caso en el que el administrador no existe con el ID proporcionado
    }

    @PostMapping
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }

    @PostMapping("/{adminId}/add-route")
    public Admin addRouteToAdmin(@PathVariable Long adminId, @RequestBody Routes route) {
        return adminService.addRouteToAdmin(adminId, route);
    }

    @DeleteMapping("/{adminId}/remove-route/{routeId}")
    public Admin removeRouteFromAdmin(@PathVariable Long adminId, @PathVariable Long routeId) {
        return adminService.removeRouteFromAdmin(adminId, routeId);
    }

    // Puedes agregar más métodos según tus necesidades, por ejemplo, para realizar operaciones específicas del administrador.
}
