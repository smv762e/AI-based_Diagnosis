package com.backend_robots.backend_robot.model;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrolleyService{
    @Autowired
    RepositoryTrolley repositoryTrolley;


       public List<Trolley> findAll(){
        return repositoryTrolley.findAll();
       }
    public Trolley findByIdTrolley(long id){
        return repositoryTrolley.findByIdTrolley(id);
    }
    public Trolley findByTechId(Technical technical){
        return repositoryTrolley.findByTechId(technical);
    }
     public void changeEstado(Trolley t){
         repositoryTrolley.changeEstado(t);
     }
     






}
