package com.backend_robots.backend_robot.repository;

import com.backend_robots.backend_robot.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAdmin extends JpaRepository<Admin, Long> {
    // Aquí puedes agregar consultas personalizadas si es necesario
}
