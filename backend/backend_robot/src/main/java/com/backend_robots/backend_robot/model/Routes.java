package com.backend_robots.backend_robot.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Routes extends Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Place finalPoint;
    private Place initialPoint;

    @ManyToMany(mappedBy = "routes")
    private List<Admin> admins;

    public Routes() {
        // Constructor vacío necesario para JPA
    }

    public Routes(Place finalPoint, Place initialPoint) {
        this.finalPoint = finalPoint;
        this.initialPoint = initialPoint;
    }

    public Place getInitialPoint() {
        return initialPoint;
    }

    public void setInitialPoint(Place initialPoint) {
        this.initialPoint = initialPoint;
    }

    public Place getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(Place finalPoint) {
        this.finalPoint = finalPoint;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }
}
