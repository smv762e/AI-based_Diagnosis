package com.backend_robots.backend_robot.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trolley")
public class Trolley {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carro;
    @Column(name = "Estado", nullable = false)
    private boolean estado;
    @ManyToOne
    @JoinColumn(name = "tecnico_id")  // nombre de la columna que representa la relación en la tabla carro
    private Technical tecnico;
    

    }