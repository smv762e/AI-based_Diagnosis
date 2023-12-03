package com.backend_robots.backend_robot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend_robots.backend_robot.model.Request;

@Repository
public interface RepositoryRequest extends JpaRepository<Request, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}

