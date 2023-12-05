package com.backend_robots.backend_robot.controller;

import com.backend_robots.backend_robot.model.Medical;
import com.backend_robots.backend_robot.model.Request;
import com.backend_robots.backend_robot.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Medical> getAllMedicals() {
        return medicalService.getAllMedicals();
    }

    @GetMapping("/{id}")
    public Medical getMedicalById(@PathVariable Long id) {
        return medicalService.getMedicalById(id)
                .orElse(null); // Manejar el caso en el que el médico no existe con el ID proporcionado
    }

    @PostMapping
    public Medical saveMedical(@RequestBody Medical medical) {
        return medicalService.saveMedical(medical);
    }

    @DeleteMapping("/{id}")
    public void deleteMedical(@PathVariable Long id) {
        medicalService.deleteMedical(id);
    }

    @PostMapping("/{medicalId}/requests")
    public Request createRequest(@PathVariable Long medicalId, @RequestBody Request request) {
        return medicalService.createRequest(medicalId, request);
    }

    @PutMapping("/{medicalId}/requests/{requestId}")
    public Request updateRequest(
            @PathVariable Long medicalId,
            @PathVariable Long requestId,
            @RequestBody Request updatedRequest
    ) {
        return medicalService.updateRequest(medicalId, requestId, updatedRequest);
    }

    // Puedes agregar más métodos según tus necesidades, por ejemplo, para realizar operaciones específicas del médico.
}
