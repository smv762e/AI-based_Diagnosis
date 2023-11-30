package com.backend_robots.backend_robot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Medical {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String user;
    private String password;

    public Medical(long id, String user, String password) {
        this.id = id;
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


    @ManyToMany
    @JoinTable(
        name = "medical_places",
        joinColumns = @JoinColumn(name = "medical_id"),
        inverseJoinColumns = @JoinColumn(name = "place_id")
    )

    private long idRuta;

    public long getIdRuta() {
        return idRuta;
    }
    public void setIdRuta(long idRuta) {
        this.idRuta = idRuta;
    }
    


}
