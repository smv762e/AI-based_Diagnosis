package com.backend_robots.backend_robot.service;
import com.backend_robots.backend_robot.model.Record;
import com.backend_robots.backend_robot.repository.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
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
            existingRecord.setCarNumber(recordDetails.getCarNumber());
            existingRecord.setTechnician(recordDetails.getTechnician());

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
