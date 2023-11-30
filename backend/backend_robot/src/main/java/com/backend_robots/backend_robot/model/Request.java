package com.backend_robots.backend_robot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public Request(String[]drugs, long Id_ruta){
        this.drugs=drugs;
        this.Id_ruta=Id_ruta;
    }

    private long Id_ruta;

    public long getId_ruta() {
        return Id_ruta;
    }

    private String[] drugs;

    public String[] getDrugs() {
        return drugs;
    }

    @ManyToOne
    private Medical Medico;

    public Medical getMedico() {
        return Medico;
    }

    public void setMedico(Medical medico) {
        Medico = medico;
    }



    
}
