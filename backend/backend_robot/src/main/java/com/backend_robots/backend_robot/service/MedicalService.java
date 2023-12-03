package com.backend_robots.backend_robot.service;

import com.backend_robots.backend_robot.model.Medical;
import com.backend_robots.backend_robot.repository.RepositoryMedical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalService {

    private final RepositoryMedical medicalRepository;

    @Autowired
    public MedicalService(RepositoryMedical medicalRepository) {
        this.medicalRepository = medicalRepository;
    }

    public List<Medical> getAllMedicals() {
        return medicalRepository.findAll();
    }

    public Medical getMedicalById(Long id) {
        Optional<Medical> medical = medicalRepository.findById(id);
        return medical.orElse(null);
    }

    public Medical createMedical(Medical medical) {
        // Aquí podrías agregar lógica adicional antes de guardar el médico, si es necesario
        return medicalRepository.save(medical);
    }

    public Medical updateMedical(Long id, Medical medicalDetails) {
        Optional<Medical> optionalMedical = medicalRepository.findById(id);
        if (optionalMedical.isPresent()) {
            Medical existingMedical = optionalMedical.get();
            // Actualizar los campos que sean necesarios
            existingMedical.setUser(medicalDetails.getUser());
            existingMedical.setPassword(medicalDetails.getPassword());
            existingMedical.setIdRuta(medicalDetails.getIdRuta());

            // Guardar el médico actualizado
            return medicalRepository.save(existingMedical);
        } else {
            return null;
        }
    }

    public void deleteMedical(Long id) {
        medicalRepository.deleteById(id);
    }
}
