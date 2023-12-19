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
public class Trolley {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long  getId(){
        return id;
    }

    public void setId(long id){
        this.id=id;       
    }

    @Column(name = "Nombre")
    private String nombre;

    public String getName(){
        return nombre;
    }

    public void setName(String nombre){
        this.nombre=nombre;
    }

    @Column(name = "Estado")
    private boolean estado;
    
    public boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado){
        this.estado=estado;
    }

    public Trolley() {
    }

    public Trolley(String nombre, Boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    @ManyToOne
    private Technical tecnicos;

    public Technical getTechnician() {
        return tecnicos;
    }

    public void setTechnician(Technical tecnicos) {
        this.tecnicos = tecnicos;
    }




    }