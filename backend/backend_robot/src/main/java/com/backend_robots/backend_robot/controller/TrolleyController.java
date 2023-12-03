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


import com.backend_robots.backend_robot.model.Trolley;
import com.backend_robots.backend_robot.service.TrolleyService;

@RestController
public class TrolleyController{
    @Autowired
    private TrolleyService trolleyService;


    @GetMapping("/trolley")
    public List<Trolley> getTrolleys(){
        return trolleyService.getAllTrolleys();

    }

    @GetMapping("/trolley/{id}")
    public Trolley getTrolley(@PathVariable("id") Long id){
        return trolleyService.getTrolley(id);
    }

    @PostMapping(value="/trolley", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> saveTrolley(@RequestBody Trolley trolley){
        try{
            trolleyService.addTrolley(trolley);
            return ResponseEntity.noContent().build();
        }
        catch(Exception ex){
            return ResponseEntity.internalServerError().body("El carro no existe");
        }
    }

    @PutMapping(value="/trolley", consumes ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateTrolley(@RequestBody Trolley trolley){
        try{
            trolleyService.updateTrolley(trolley);
             return ResponseEntity.noContent().build();
        }catch(Exception ex){
              ex.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al actualizar el trolley");
        }
    }
    @DeleteMapping("/trolley/{id}")
    public ResponseEntity<?> deleteTrolley(@PathVariable("id") Long id) {
        try{
            trolleyService.removetrolleyID(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al eliminar la cuenta");
        }
    }

}