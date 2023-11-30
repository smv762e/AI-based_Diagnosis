package com.backend_robots.backend_robot.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMedical extends JpaRepository<Medical, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}

