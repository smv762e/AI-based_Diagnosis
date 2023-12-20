package com.backend_robots.backend_robot.controller;

import com.backend_robots.backend_robot.model.Admin;
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
    public Admin getAdminById(@PathVariable long id) {
        return adminService.getAdminById(id)
                .orElse(null); // Manejar el caso en el que el administrador no existe con el ID proporcionado
    }
     @PostMapping("/login") // Ruta específica para el inicio de sesión
    public boolean loginAdmin(@RequestParam String user, @RequestParam String password) {
        // Lógica para verificar el inicio de sesión en tu servicio
        return adminService.loginAdmin(user, password);
    }

    @PostMapping
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable long id) {
        adminService.deleteAdmin(id);
    }

}
