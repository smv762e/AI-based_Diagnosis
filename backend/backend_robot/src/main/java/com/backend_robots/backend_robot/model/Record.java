package com.backend_robots.backend_robot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "request_id")  // Nombre de la columna en la tabla de la entidad relacionada
    private Routes route;

    @Column(name = "car_number")
    private long carNumber;

    @ManyToOne
    @JoinColumn(name = "technician_id")  // Nombre de la columna en la tabla de la entidad relacionada
    private Technical technician;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Routes getRoute() {
        return route;
    }

    public long getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(long carNumber) {
        this.carNumber = carNumber;
    }

    public Technical getTechnician() {
        return technician;
    }

    public void setTechnician(Technical technician) {
        this.technician = technician;
    }
     public Record() {
    }
    public Record(Routes route, long carNumber, Technical technician) {
        this.route = route;
        this.carNumber = carNumber;
        this.technician = technician;
    }

}


