package com.backend_robots.backend_robot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;  // Importa List

@Entity
public class Medical {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nombre")
    private String user;

    @Column(name = "contraseña")
    private String password;

    @ManyToMany
    @JoinTable(
        name = "medical_places",
        joinColumns = @JoinColumn(name = "medical_id"),
        inverseJoinColumns = @JoinColumn(name = "route_id")
    )
    private List<Routes> routes;  // Cambia el tipo a List<Routes>

    public Medical() {
        // Constructor vacío necesario para JPA
    }

    public Medical(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Routes> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Routes> routes) {
        this.routes = routes;
    }
}
