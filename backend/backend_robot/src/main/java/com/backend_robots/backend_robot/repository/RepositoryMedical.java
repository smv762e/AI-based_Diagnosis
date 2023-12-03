package com.backend_robots.backend_robot.repository;

import com.backend_robots.backend_robot.model.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMedical extends JpaRepository<Medical, Long> {
    // Puedes agregar métodos personalizados de consulta si es necesario
    // Por ejemplo:
    // Medical findByUser(String username);
}
