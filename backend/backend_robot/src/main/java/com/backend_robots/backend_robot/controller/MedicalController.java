package com.backend_robots.backend_robot.controller;

import com.backend_robots.backend_robot.model.Medical;
import com.backend_robots.backend_robot.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicals")
public class MedicalController {

    private final MedicalService medicalService;

    @Autowired
    public MedicalController(MedicalService medicalService) {
        this.medicalService = medicalService;
    }

    @GetMapping
    public ResponseEntity<List<Medical>> getAllMedicals() {
        List<Medical> medicals = medicalService.getAllMedicals();
        return new ResponseEntity<>(medicals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medical> getMedicalById(@PathVariable("id") Long id) {
        Medical medical = medicalService.getMedicalById(id);
        if (medical != null) {
            return new ResponseEntity<>(medical, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Medical> createMedical(@RequestBody Medical medical) {
        Medical createdMedical = medicalService.createMedical(medical);
        return new ResponseEntity<>(createdMedical, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medical> updateMedical(
            @PathVariable("id") Long id,
            @RequestBody Medical medicalDetails) {
        Medical updatedMedical = medicalService.updateMedical(id, medicalDetails);
        if (updatedMedical != null) {
            return new ResponseEntity<>(updatedMedical, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMedical(@PathVariable("id") Long id) {
        medicalService.deleteMedical(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
