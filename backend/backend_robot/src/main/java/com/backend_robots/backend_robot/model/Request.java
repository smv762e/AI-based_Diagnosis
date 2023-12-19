package com.backend_robots.backend_robot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "drugs")
    private String drugs;

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public String getDrugs() {
        return drugs;
    }

    @Column(name = "route")
    private String route;

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Request() {
        
    }

    public Request(String drugs, String route) {
        this.drugs = drugs;
        this.route = route;
    }

    @ManyToOne
    private Medical Medico;

    public Medical getMedico() {
        return Medico;
    }

    public void setMedico(Medical medico) {
        Medico = medico;
    }

    @ManyToOne
    private Technical technician;

    public Technical getTechnician() {
        return technician;
    }

    public void setTechnician(Technical technician) {
        this.technician = technician;
    }

}
