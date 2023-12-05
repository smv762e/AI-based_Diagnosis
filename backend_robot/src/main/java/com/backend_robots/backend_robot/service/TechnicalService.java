package com.backend_robots.backend_robot.service;

import com.backend_robots.backend_robot.model.Record;
import com.backend_robots.backend_robot.model.Technical;
import com.backend_robots.backend_robot.repository.TechnicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicalService {

    private final TechnicalRepository technicalRepository;

    @Autowired
    public TechnicalService(TechnicalRepository technicalRepository) {
        this.technicalRepository = technicalRepository;
    }

    public Technical getTechnicalById(long technicalId) {
        return technicalRepository.findById(technicalId).orElse(null);
    }

    public void sendCarAndUpdateStatus(long technicalId, long requestId, long carNumber) {
        Technical technical = technicalRepository.findById(technicalId).orElse(null);
        if (technical != null) {
            // Cambiar el estado del carro (implementa la lógica según tus necesidades)
            boolean carStatus = cambiarEstadoCarro(carNumber);

            // Si el estado del carro cambió correctamente
            if (carStatus) {
                // Crear un nuevo registro con el id de la solicitud y el número de carro
                Record record = createRecord(requestId, carNumber);

                // Agregar el registro al técnico
                ((Technical) technical).addRecord(record);

                // Actualizar el técnico en la base de datos
                technicalRepository.save(technical);
            }
        }
    }

    private boolean cambiarEstadoCarro(long carNumber) {
      
        return true;
    }

    private Record createRecord(long requestId, long carNumber) {
    // Crea un nuevo registro con el id de la solicitud, el número de carro y la fecha actual
    Record record = new Record();
    record.setCarNumber(carNumber);

    return record;
    }

}
