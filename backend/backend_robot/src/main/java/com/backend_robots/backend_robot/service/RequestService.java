package com.backend_robots.backend_robot.service;

import com.backend_robots.backend_robot.model.Request;
import com.backend_robots.backend_robot.repository.RepositoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    private final RepositoryRequest requestRepository;

    @Autowired
    public RequestService(RepositoryRequest requestRepository) {
        this.requestRepository = requestRepository;
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Request getRequestById(Long id) {
        Optional<Request> request = requestRepository.findById(id);
        return request.orElse(null);
    }

    public Request createRequest(Request request) {
        // Aquí podrías agregar lógica adicional antes de guardar la solicitud, si es necesario
        return requestRepository.save(request);
    }

    public Request updateRequest(Long id, Request requestDetails) {
        Optional<Request> optionalRequest = requestRepository.findById(id);
        if (optionalRequest.isPresent()) {
            Request existingRequest = optionalRequest.get();
            // Actualizar los campos que sean necesarios
            existingRequest.setDrugs(requestDetails.getDrugs());
            existingRequest.setId_ruta(requestDetails.getId_ruta());
            existingRequest.setMedico(requestDetails.getMedico());

            // Guardar la solicitud actualizada
            return requestRepository.save(existingRequest);
        } else {
            return null;
        }
    }

    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }
}
