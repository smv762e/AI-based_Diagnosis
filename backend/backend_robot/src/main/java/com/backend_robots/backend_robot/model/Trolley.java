package com.backend_robots.backend_robot.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "trolley")
public class Trolley {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carro;
    public long  getId_carro(){
        return id_carro;
    }

    public void setId_carro(long id){
        this.id_carro=id;
        
    }

    @Column(name = "Estado")
    private boolean estado;
    public boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado){
        this.estado=estado;
    }

    @ManyToMany
    @JoinTable(
    name = "trolley_technical",
    joinColumns = @JoinColumn(name = "id_carro"),
    inverseJoinColumns = @JoinColumn(name = "tecnico_id")
    )
    private List<Technical> tecnicos;




    }