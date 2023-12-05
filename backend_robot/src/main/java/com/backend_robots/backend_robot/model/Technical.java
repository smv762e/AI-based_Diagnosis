package com.backend_robots.backend_robot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.*;

@Entity
public class Technical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "nombre")
    private String user;
    @Column(name = "contraseña")
    private String password;

    public Technical(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Technical() {
    }

    public long getId() {
        return Id;
    }

    public String getUsuario() {
        return user;
    }

    public void setUsuario(String usuario) {
        this.user = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "technician")
    private java.util.List<Record> registros;

    public java.util.List<Record> getRegistros() {
        return registros;
    }

    @ManyToMany(mappedBy = "tecnicos")
    private List<Trolley> carros;

    public void addRecord(Record record) {
    }

}
