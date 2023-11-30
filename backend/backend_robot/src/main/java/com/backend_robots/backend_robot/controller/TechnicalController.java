package com.backend_robots.backend_robot.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.backend_robots.backend_robot.model.Technical;
import com.backend_robots.backend_robot.model.TechnicalService;

@RestController
public class TechnicalController{
    @Autowired
    TechnicalService technicalService;

    @GetMapping("/technical")
    public List<Technical> getTechnicals(){
        return technicalService.findAll();
    }
    //No estoy seguro 
    @GetMapping("/technical/{id}")
    public Technical getTechnical(@PathVariable("id") long id){
        return technicalService.getTechnical(id);
    }

    @PostMapping(value = "/technical",consumes=MediaType.APPLICATION_JSON_VALUE)
    public Technical addTechnical(@RequestBody Technical technical){
     return technicalService.addTechnical(technical);   
    }

    //Toda la parte de actualizar esta de manera basica 
    @PutMapping(value= "/technical",consumes=MediaType.APPLICATION_JSON_VALUE)
    public void updatedTechnical(@RequestBody Technical technical){
        technicalService.updateTechnical(technical);
    }
    
    @DeleteMapping("technical/{id}")
    public void deleteTechnical(@PathVariable("id") long id){
        technicalService.deleteTecnico(id);
    }

}