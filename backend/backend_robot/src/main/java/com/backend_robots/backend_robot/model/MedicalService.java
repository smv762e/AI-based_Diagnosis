package com.backend_robots.backend_robot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalService {

    private RepositoryMedical medicoRepository;
    private RepositoryRequest requestRepository;

    @Autowired
    public void MedicoService(RepositoryMedical medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medical guardarMedico(Medical medicoRequest) {
        return medicoRepository.save(medicoRequest);
    }

    public Medical obtenerMedicoPorId(long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public List<Medical> obtenerTodosLosMedicos() {
        return medicoRepository.findAll();
    }
    public void eliminarMedico(Medical medicoRequest) {
        medicoRepository.delete(medicoRequest);
    }

    public void eliminarMedicoPorId(long id) {
        medicoRepository.deleteById(id);
    }

    public Request crearSolicitud(Medical medicoRequest, String[] drugs, long idRuta) {

            Request solicitud = new Request(drugs, idRuta);
            solicitud.setMedico(medicoRequest); // Asumiendo un método setter en Request

            // Guardar la solicitud
            return requestRepository.save(solicitud);
        } 


    
}
