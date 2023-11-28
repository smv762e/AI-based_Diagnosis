package com.backend_robots.backend_robot.model;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTechnical extends JpaRepository<Technical,Long>{
    Technical findById(long id);
    Technical findByUser(String user);
    List<Technical> findAll();
}