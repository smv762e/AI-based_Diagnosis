package com.backend_robots.backend_robot.model;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTrolley extends JpaRepository<Trolley,Long>{
    List<Trolley> findAll();
    Trolley findByIdTrolley(long id);
    Trolley findByTechId(Technical technical);
     void changeEstado(Trolley t);

}