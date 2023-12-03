package com.backend_robots.backend_robot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend_robots.backend_robot.model.Technical;
import com.backend_robots.backend_robot.repository.RepositoryTechnical;

@Service
public class TechnicalService{
    @Autowired
    RepositoryTechnical repositoryTechnical;

    public List<Technical> findAll(){
        return repositoryTechnical.findAll();
    }

    public Technical getTechnical(long id){
        return repositoryTechnical.findById(id);
    
    }

    public Technical addTechnical(Technical tecnico){
        return repositoryTechnical.save(tecnico);
    }
    public void deleteTecnico(long id){
         repositoryTechnical.deleteById(id);
    }
    public void updateTechnical(Technical technical){
        repositoryTechnical.save(technical);
    }
}