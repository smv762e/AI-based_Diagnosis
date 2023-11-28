package com.backend_robots.backend_robot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Medical {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String pasword;
    public String pasword() {
        return pasword;
    }
    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void crearSolicitud(long Id_ruta){}

    @ManyToOne
    private Rutas ruta;
    

    public Rutas getRuta() {
        return ruta;
    }
    public void setRuta(Rutas ruta) {
        this.ruta = ruta;
    }
    
    @ManyToOne
    private Request solicitud;
    public Request getsolicitud() {
        return solicitud;
    }

    public void setSol(Request solicitud) {
        this.solicitud = solicitud;
    }


}
