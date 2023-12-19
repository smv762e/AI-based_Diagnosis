package com.backend_robots.backend_robot.service;

import com.backend_robots.backend_robot.model.Request;
import com.backend_robots.backend_robot.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
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
        return requestRepository.save(request);
    }

    public Request updateRequest(Long id, Request requestDetails) {
        Optional<Request> optionalRequest = requestRepository.findById(id);
        if (optionalRequest.isPresent()) {
            Request existingRequest = optionalRequest.get();
            existingRequest.setDrugs(requestDetails.getDrugs());
            existingRequest.setMedico(requestDetails.getMedico());
            return requestRepository.save(existingRequest);
        } else {
            return null;
        }
    }

    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }
}
