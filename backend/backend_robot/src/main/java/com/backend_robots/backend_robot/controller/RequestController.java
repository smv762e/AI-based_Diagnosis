package com.backend_robots.backend_robot.controller;

import com.backend_robots.backend_robot.model.Request;
import com.backend_robots.backend_robot.model.Trolley;
import com.backend_robots.backend_robot.service.RequestService;
import com.backend_robots.backend_robot.service.TrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {

    private final RequestService requestService;
    private final TrolleyService trolleyService;

    @Autowired
    public RequestController(RequestService requestService, TrolleyService trolleyService) {
        this.requestService = requestService;
        this.trolleyService = trolleyService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> updateRequest(
            @PathVariable("id") Long id,
            @RequestBody Request requestDetails) {
        Request updatedRequest = requestService.updateRequest(id, requestDetails);
        if (updatedRequest != null) {
            // Verificar si la solicitud ha sido aceptada y cambiar el estado del carro
            if (updatedRequest.isAccepted()) {
                Trolley trolley = updatedRequest.getTrolley();
                if (trolley != null) {
                    trolleyService.changeTrolleyState(trolley.getId(), true);
                }
            }
            return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

  

    @GetMapping
    public ResponseEntity<List<Request>> getAllRequests() {
        List<Request> requests = requestService.getAllRequests();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequestById(@PathVariable("id") Long id) {
        Request request = requestService.getRequestById(id);
        if (request != null) {
            return new ResponseEntity<>(request, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody Request request) {
        Request createdRequest = requestService.createRequest(request);
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }



    

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRequest(@PathVariable("id") Long id) {
        requestService.deleteRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/accept/{id}")
    public ResponseEntity<Request> acceptRequest(@PathVariable("id") Long id, @RequestBody Map<String, Long> requestBody) {
        Long robotId = requestBody.get("robotId");

        // Verifica la existencia de la solicitud
        Request existingRequest = requestService.getRequestById(id);
        if (existingRequest == null) {
            // La solicitud no existe
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Actualiza el estado de la solicitud
        existingRequest.setAccepted(true);
        requestService.updateRequest(robotId, existingRequest);

        // Aquí puedes agregar más lógica si es necesario

        // Obtiene el carro asociado desde el Optional
        Optional<Trolley> optionalTrolley = trolleyService.getTrolleyById(robotId);
        if (optionalTrolley.isPresent()) {
            Trolley trolley = optionalTrolley.get();

            // Cambia el estado del carro asociado
            trolley.setEstado(false);
            trolleyService.saveTrolley(trolley);

            return new ResponseEntity<>(existingRequest, HttpStatus.OK);
        } else {
            // El carro no existe
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
