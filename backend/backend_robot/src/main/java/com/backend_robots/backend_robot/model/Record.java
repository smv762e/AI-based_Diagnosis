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

}