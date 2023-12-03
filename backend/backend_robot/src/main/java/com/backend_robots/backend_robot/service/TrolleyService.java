package com.backend_robots.backend_robot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend_robots.backend_robot.model.Technical;
import com.backend_robots.backend_robot.model.Trolley;
import com.backend_robots.backend_robot.repository.RepositoryTrolley;

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
	public List<Trolley> getAllTrolleys() {
		return null;
	}
     public Trolley getTrolley( long id){
        return repositoryTrolley.getById(id);
     }
	public void addTrolley(Trolley trolley) {
        repositoryTrolley.addTrolley(trolley);
	}

     






}
