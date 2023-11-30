package com.backend_robots.backend_robot.model;

import com.backend_robots.backend_robot.model.Routes;
import com.backend_robots.backend_robot.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutesRepository extends JpaRepository<Routes, Long> {
    List<Routes> findByInitialPoint(Place initialPoint);
}
