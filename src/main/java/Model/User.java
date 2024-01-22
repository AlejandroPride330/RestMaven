/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alex
 */
@Entity
@Table(name="Users")
@XmlRootElement
public class User {
    @Id
    @Column(name="id")
    private String id;
    @Column(name=" name")
    private String name;
    @Column(name=" rol")
    private String rol;
    @Column(name=" yearBirth")
    private int yearBirth;

    public User() {
    }

    public User(String id,String name, String rol, int yearBirth) {
        this.id= id;
        this.name = name;
        this.rol = rol;
        this.yearBirth = yearBirth;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", rol=" + rol + ", yearBirth=" + yearBirth + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }           
}

    

