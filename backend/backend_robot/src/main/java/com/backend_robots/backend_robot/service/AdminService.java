package com.backend_robots.backend_robot.service;

import com.backend_robots.backend_robot.model.Admin;
import com.backend_robots.backend_robot.repository.RepositoryAdmin;
import com.backend_robots.backend_robot.repository.RepositoryMedical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    // Aquí deberías tener un repositorio RepositoryAdmin que gestione las operaciones con la base de datos
    private final RepositoryAdmin adminRepository;

    @Autowired
    public AdminService(RepositoryAdmin adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        // Implementa la lógica para obtener todos los admins
        return adminRepository.findAll();
    }

    public Admin getAdminById(long id) {
        // Implementa la lógica para obtener un admin por su ID
        return adminRepository.findById(id).orElse(null);
    }   

    public Admin createAdmin(Admin admin) {
        // Implementa la lógica para crear un admin
        return adminRepository.save(admin);
    }
    public Admin updateAdmin(long id, Admin admin) {
        if (adminRepository.existsById(id)) {
            admin.setId(id);
            return adminRepository.save(admin);
        } else {
            // Manejar la lógica de error, por ejemplo, lanzar una excepción
            return null;
        }

    public void deleteAdmin(long id) {
        // Implementa la lógica para eliminar un admin por su ID
        adminRepository.deleteById(id);
    }
}
