package com.backend_robots.backend_robot.service;
import com.backend_robots.backend_robot.model.Record;
import com.backend_robots.backend_robot.repository.RepositoryRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    private final RepositoryRecord recordRepository;

    @Autowired
    public RecordService(RepositoryRecord recordRepository) {
        this.recordRepository = recordRepository;
    }

    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    public Record getRecordById(Long id) {
        Optional<Record> record = recordRepository.findById(id);
        return record.orElse(null);
    }

    public Record createRecord(Record record) {
        // Aquí podrías agregar lógica adicional antes de guardar el registro, si es necesario
        return recordRepository.save(record);
    }

    public Record updateRecord(Long id, Record recordDetails) {
        Optional<Record> optionalRecord = recordRepository.findById(id);
        if (optionalRecord.isPresent()) {
            Record existingRecord = optionalRecord.get();
            // Actualizar los campos que sean necesarios
            existingRecord.setN_carro(recordDetails.getN_carro());
            existingRecord.setH_inicio(recordDetails.getH_inicio());
            existingRecord.setH_fin(recordDetails.getH_fin());
            existingRecord.setFecha(recordDetails.getFecha());
            existingRecord.setTecnico(recordDetails.getTecnico());

            // Guardar el registro actualizado
            return recordRepository.save(existingRecord);
        } else {
            return null;
        }
    }

    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
}
