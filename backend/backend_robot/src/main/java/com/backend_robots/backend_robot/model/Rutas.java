package com.backend_robots.backend_robot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rutas extends Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Place p_llegada;
    private Place p_inicio;

    public Rutas(long id, Place p_llegada, Place p_inicio) {
        this.id = id;
        this.p_llegada = p_llegada;
        this.p_inicio = p_inicio;
    }

    public Place getP_inicio() {
        return p_inicio;
    }

    public void setP_inicio(Place p_inicio) {
        this.p_inicio = p_inicio;
    }

    public Place getP_llegada() {
        return p_llegada;
    }

    public void setP_llegada(Place p_llegada) {
        this.p_llegada = p_llegada;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ruta [id=" + id + ", Inicio=" + p_inicio + ", Llegada=" + p_llegada + "]";
    }

}
