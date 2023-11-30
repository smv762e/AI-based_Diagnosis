package com.backend_robots.backend_robot.model;


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
        Optional<Record> recordOptional = recordRepository.findById(id);
        return recordOptional.orElse(null);
    }

    public Record createRecord(Record record) {
        return recordRepository.save(record);
    }

    public Record updateRecord(Long id, Record recordDetails) {
        Optional<Record> recordOptional = recordRepository.findById(id);
        if (recordOptional.isPresent()) {
            Record existingRecord = recordOptional.get();
            // Aquí podrías realizar las actualizaciones necesarias en existingRecord con los datos de recordDetails
            // Por ejemplo, existingRecord.setN_carro(recordDetails.getN_carro());
            // Luego, guarda el registro actualizado
            return recordRepository.save(existingRecord);
        } else {
            return null;
        }
    }

    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
}
