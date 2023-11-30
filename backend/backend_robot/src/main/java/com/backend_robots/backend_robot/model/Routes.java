package com.backend_robots.backend_robot.model;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Routes extends Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Place finalPoint;
    private Place initialPoint;

    public Routes(long id, Place finalPoint, Place initialPoint) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Route [Id=" + id + ", Start point=" + initialPoint + ", Final point=" + finalPoint + "]";
    }

    @ManyToMany(mappedBy = "drugs")
    private List<Medical> medicoRequests;

}
