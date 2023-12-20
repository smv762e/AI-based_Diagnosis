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

    public Request(String drugs, String route, boolean accepted, Trolley trolley, Medical medico, Technical technician) {
        this.drugs = drugs;
        this.route = route;
        this.accepted = accepted;
        this.trolley = trolley;
        this.medico = medico;
        this.technician = technician;
    }

    @Column(name = "accepted")
    private boolean accepted = false;

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @ManyToOne
    private Trolley trolley;

    public Trolley getTrolley() {
        return trolley;
    }

    public void setTrolley(Trolley trolley) {
        this.trolley = trolley;
    }

    @ManyToOne
    private Medical medico;

    public Medical getMedico() {
        return medico;
    }

    public void setMedico(Medical medico) {
        this.medico = medico;
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
