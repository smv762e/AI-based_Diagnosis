package com.backend_robots.backend_robot.controller;

import com.backend_robots.backend_robot.model.Record;
import com.backend_robots.backend_robot.model.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    // Endpoint para obtener todos los registros
    @GetMapping
    public ResponseEntity<List<Record>> getAllRecords() {
        List<Record> records = recordService.getAllRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    // Endpoint para obtener un registro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordById(@PathVariable("id") Long id) {
        Record record = recordService.getRecordById(id);
        if (record != null) {
            return new ResponseEntity<>(record, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para crear un nuevo registro
    @PostMapping
    public ResponseEntity<Record> createRecord(@RequestBody Record record) {
        Record createdRecord = recordService.createRecord(record);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un registro existente
    @PutMapping("/{id}")
    public ResponseEntity<Record> updateRecord(
            @PathVariable("id") Long id,
            @RequestBody Record recordDetails) {
        Record updatedRecord = recordService.updateRecord(id, recordDetails);
        if (updatedRecord != null) {
            return new ResponseEntity<>(updatedRecord, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un registro
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRecord(@PathVariable("id") Long id) {
        recordService.deleteRecord(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
