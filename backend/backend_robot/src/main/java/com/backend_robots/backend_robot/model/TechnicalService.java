package com.backend_robots.backend_robot.model;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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