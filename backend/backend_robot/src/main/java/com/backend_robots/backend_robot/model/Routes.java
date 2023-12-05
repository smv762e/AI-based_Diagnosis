package com.backend_robots.backend_robot.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String finalPoint;
    private String initialPoint;

    @ManyToMany(mappedBy = "routes")
    private List<Admin> admins;

    @ManyToMany(mappedBy = "routes")
    private List<Medical> medicals;

    public List<Medical> getMedicals() {
		return medicals;
	}

	public void setMedicals(List<Medical> medicals) {
		this.medicals = medicals;
	}

	public Routes() {
        // Constructor vacío necesario para JPA
    }

    public Routes(String finalPoint, String initialPoint) {
        this.finalPoint = finalPoint;
        this.initialPoint = initialPoint;
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

    public Long getId() {
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
