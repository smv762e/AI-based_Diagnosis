package com.backend_robots.backend_robot.service;

import com.backend_robots.backend_robot.model.Trolley;
import com.backend_robots.backend_robot.repository.TrolleyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrolleyService {

    private final TrolleyRepository trolleyRepository;

    @Autowired
    public TrolleyService(TrolleyRepository trolleyRepository) {
        this.trolleyRepository = trolleyRepository;
    }

    public List<Trolley> getAllTrolleys() {
        return trolleyRepository.findAll();
    }

    public Optional<Trolley> getTrolleyById(Long id) {
        return trolleyRepository.findById(id);
    }

    public void  saveTrolley(Trolley trolley) {
        trolleyRepository.save(trolley);
    }

    public void deleteTrolley(Long id) {
        trolleyRepository.deleteById(id);
    }

    public void changeTrolleyState(Long id, boolean newState) {
    Optional<Trolley> optionalTrolley = trolleyRepository.findById(id);
    optionalTrolley.ifPresent(trolley -> {
        trolley.setEstado(newState);
        trolleyRepository.save(trolley);
    });
}


    

}
