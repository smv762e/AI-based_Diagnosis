package com.backend_robots.backend_robot.service;

import com.backend_robots.backend_robot.model.Admin;
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

    public boolean loginAdmin(String user, String password) {
        Optional<Admin> adminOptional = adminRepository.findByUserAndPassword(user, password);

        // Verifica si el usuario y la contraseña son válidos
        return adminOptional.isPresent();
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
