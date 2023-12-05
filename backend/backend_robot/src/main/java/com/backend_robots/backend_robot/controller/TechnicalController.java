package com.backend_robots.backend_robot.controller;

import com.backend_robots.backend_robot.model.Technical;
import com.backend_robots.backend_robot.service.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/technical")
public class TechnicalController {

    private final TechnicalService technicalService;

    @Autowired
    public TechnicalController(TechnicalService technicalService) {
        this.technicalService = technicalService;
    }

    @GetMapping("/{technicalId}")
    public ResponseEntity<Technical> getTechnicalById(@PathVariable long technicalId) {
        Technical technical = technicalService.getTechnicalById(technicalId);
        return technical != null
                ? new ResponseEntity<>(technical, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{technicalId}/sendCar")
    public ResponseEntity<String> sendCarAndUpdateStatus(
            @PathVariable long technicalId,
            @RequestParam long requestId,
            @RequestParam long carNumber
    ) {
        try {
            technicalService.sendCarAndUpdateStatus(technicalId, requestId, carNumber);
            return new ResponseEntity<>("Car sent successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to send car: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
