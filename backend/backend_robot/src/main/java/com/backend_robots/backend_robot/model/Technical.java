package com.backend_robots.backend_robot.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.*;

@Entity
@Table(name = "tecnico")
public class Technical{
 @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private long Id;   

  public Long getId() {
        return Id;
    }
@Column(unique = true, name = "user", nullable = false)
    private String user;
    public String getUsuario() {
        return user;
    }
    public void setUsuario(String usuario) {
        this.user = usuario;
    }
    @Column(name = "password", nullable = false)
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }





 @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL)
private java.util.List<Record> registros;

public java.util.List<Record> getRegistros() {
    return registros;
}
@OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL)
private List<Trolley> carros;


}

