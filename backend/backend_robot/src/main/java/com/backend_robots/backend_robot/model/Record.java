package com.backend_robots.backend_robot.model;
import java.time.LocalDate;

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
    private Long ID_ruta;

    @Column (name = "Número carro", nullable = false)
    private Long N_carro;

    @Column(name = "Hora inicio", nullable = false)
    private String H_inicio;
    @Column(name = "Hora fin", nullable = false)
    private String H_fin;
    @Column(name = "Fecha", nullable = false)
    private LocalDate Fecha;
    @ManyToOne // Indica la relación muchos a uno
    @JoinColumn(name = "tecnico_id") // Nombre de la columna en la tabla Registro que hace referencia al Tecnico
    private Technical tecnico;

      @ManyToOne // Indica la relación muchos a uno
    @JoinColumn(name = "tecnico_id") // Nombre de la columna en la tabla Registro que hace referencia al Tecnico

    // Getters y setters para todos los campos
    public Long getID_ruta() {
        return ID_ruta;
    }

    public void setID_ruta(Long ID_ruta) {
        this.ID_ruta = ID_ruta;
    }

    public Long getN_carro() {
        return N_carro;
    }

    public void setN_carro(Long N_carro) {
        this.N_carro = N_carro;
    }

    public String getH_inicio() {
        return H_inicio;
    }

    public void setH_inicio(String H_inicio) {
        this.H_inicio = H_inicio;
    }

    public String getH_fin() {
        return H_fin;
    }

    public void setH_fin(String H_fin) {
        this.H_fin = H_fin;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }

    public Technical getTecnico() {
        return tecnico;
    }

    public void setTecnico(Technical tecnico) {
        this.tecnico = tecnico;
    }
}


