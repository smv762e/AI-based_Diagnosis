package com.backend_robots.backend_robot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend_robots.backend_robot.model.Trolley;
import com.backend_robots.backend_robot.model.Technical;

public interface RepositoryTrolley extends JpaRepository<Trolley,Long>{

Trolley findByIdTrolley(long id);
Trolley findByTechId(Technical technical);
 void changeEstado(Trolley t);
 Trolley findByTechId(long id);
Trolley getTrolley(long id);
void  addTrolley( Trolley t);
 void updateTrolley(Trolley t);



}