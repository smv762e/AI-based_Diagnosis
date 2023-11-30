package com.backend_robots.backend_robot.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRequest extends JpaRepository<Request, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}

