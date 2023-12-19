package com.backend_robots.backend_robot.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Final", columnDefinition = "VARCHAR(255)")
    private String finalPoint;
    @Column(name = "Inicio", columnDefinition = "VARCHAR(255)")
    private String initialPoint;

	public Routes() {
    }

    public Routes(String initialPoint, String finalPoint) {
        this.initialPoint = initialPoint;
        this.finalPoint = finalPoint;
    }

    public String getInitialPoint() {
        return initialPoint;
    }

    public void setInitialPoint(String initialPoint) {
        this.initialPoint = initialPoint;
    }

    public String getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(String finalPoint) {
        this.finalPoint = finalPoint;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Routes routes = (Routes) o;
        return Objects.equals(id, routes.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    
}
