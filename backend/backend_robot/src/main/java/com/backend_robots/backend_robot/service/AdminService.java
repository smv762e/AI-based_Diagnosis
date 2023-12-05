package com.backend_robots.backend_robot.service;

import com.backend_robots.backend_robot.model.Admin;
import com.backend_robots.backend_robot.model.Routes;
import com.backend_robots.backend_robot.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    public Admin addRouteToAdmin(Long adminId, Routes route) {
        Optional<Admin> optionalAdmin = adminRepository.findById(adminId);
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            List<Routes> adminRoutes = admin.getRoutes();
            adminRoutes.add(route);
            admin.setRoutes(adminRoutes);
            return adminRepository.save(admin);
        } else {
            // Manejar el caso en el que el administrador no existe con el ID proporcionado
            // Puedes lanzar una excepción o manejarlo de otra manera según tus necesidades
            return null;
        }
    }

    public Admin removeRouteFromAdmin(Long adminId, Long routeId) {
        Optional<Admin> optionalAdmin = adminRepository.findById(adminId);
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            List<Routes> adminRoutes = admin.getRoutes();
            adminRoutes.removeIf(route -> route.getId() == routeId);
            admin.setRoutes(adminRoutes);
            return adminRepository.save(admin);
        } else {
            // Manejar el caso en el que el administrador no existe con el ID proporcionado
            // Puedes lanzar una excepción o manejarlo de otra manera según tus necesidades
            return null;
        }
    }

    // Puedes agregar más métodos según tus necesidades, por ejemplo, para realizar operaciones específicas del administrador.
}
