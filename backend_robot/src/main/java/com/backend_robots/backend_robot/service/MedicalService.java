package com.backend_robots.backend_robot.service;

import com.backend_robots.backend_robot.model.Medical;
import com.backend_robots.backend_robot.model.Request;
import com.backend_robots.backend_robot.repository.MedicalRepository;
import com.backend_robots.backend_robot.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalService {

    private final MedicalRepository medicalRepository;
    private final RequestRepository requestRepository;

    @Autowired
    public MedicalService(MedicalRepository medicalRepository, RequestRepository requestRepository) {
        this.medicalRepository = medicalRepository;
        this.requestRepository = requestRepository;
    }

    public List<Medical> getAllMedicals() {
        return medicalRepository.findAll();
    }

    public Optional<Medical> getMedicalById(Long id) {
        return medicalRepository.findById(id);
    }

    public Medical saveMedical(Medical medical) {
        return medicalRepository.save(medical);
    }

    public void deleteMedical(Long id) {
        medicalRepository.deleteById(id);
    }

    public Request createRequest(Long medicalId, Request request) {
        Optional<Medical> optionalMedical = medicalRepository.findById(medicalId);
        if (optionalMedical.isPresent()) {
            Medical medical = optionalMedical.get();
            request.setMedico(medical);
            return requestRepository.save(request);
        } else {
            // Manejar el caso en el que el médico no existe con el ID proporcionado
            return null;
        }
    }

    public Request updateRequest(Long medicalId, Long requestId, Request updatedRequest) {
        Optional<Medical> optionalMedical = medicalRepository.findById(medicalId);
        if (optionalMedical.isPresent()) {
            Optional<Request> optionalRequest = requestRepository.findById(requestId);
            if (optionalRequest.isPresent()) {
                Request existingRequest = optionalRequest.get();
                // Realiza las actualizaciones necesarias en la solicitud existente
                existingRequest.setDrugs(updatedRequest.getDrugs());
                // Puedes agregar más campos según tus necesidades
                return requestRepository.save(existingRequest);
            } else {
                // Manejar el caso en el que la solicitud no existe con el ID proporcionado
                // Puedes lanzar una excepción o manejarlo de otra manera según tus necesidades
                return null;
            }
        } else {
            // Manejar el caso en el que el médico no existe con el ID proporcionado
            // Puedes lanzar una excepción o manejarlo de otra manera según tus necesidades
            return null;
        }
    }

    // Puedes agregar más métodos según tus necesidades, por ejemplo, para realizar operaciones específicas del médico.
}
