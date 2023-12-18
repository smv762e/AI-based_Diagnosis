package com.backend_robots.backend_robot.controller;

import com.backend_robots.backend_robot.model.Trolley;
import com.backend_robots.backend_robot.service.TrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trolleys")
public class TrolleyController {

    private final TrolleyService trolleyService;

    @Autowired
    public TrolleyController(TrolleyService trolleyService) {
        this.trolleyService = trolleyService;
    }

    @GetMapping
    public List<Trolley> getAllTrolleys() {
        return trolleyService.getAllTrolleys();
    }

    @GetMapping("/{id}")
    public Trolley getTrolleyById(@PathVariable Long id) {
        return trolleyService.getTrolleyById(id)
                .orElse(null); // Manejar el caso en el que el carro no existe con el ID proporcionado
    }

    @PostMapping
    public Trolley saveTrolley(@RequestBody Trolley trolley) {
        return trolleyService.saveTrolley(trolley);
    }

    @DeleteMapping("/{id}")
    public void deleteTrolley(@PathVariable Long id) {
        trolleyService.deleteTrolley(id);
    }

    @PatchMapping("/{id}/change-state")
    public void changeTrolleyState(@PathVariable Long id, @RequestParam boolean newState) {
        trolleyService.changeTrolleyState(id, newState);
    }

}
