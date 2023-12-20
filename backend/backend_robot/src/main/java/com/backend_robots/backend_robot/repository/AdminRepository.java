package com.backend_robots.backend_robot.repository;

import com.backend_robots.backend_robot.model.Admin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUserAndPassword(String user, String password);
   
}
