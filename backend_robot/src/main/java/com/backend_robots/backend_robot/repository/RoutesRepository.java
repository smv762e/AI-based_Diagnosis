package com.backend_robots.backend_robot.repository;

import com.backend_robots.backend_robot.model.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoutesRepository extends JpaRepository<Routes, Long> {

}
