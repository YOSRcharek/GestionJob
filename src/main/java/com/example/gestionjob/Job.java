package com.example.gestionjob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;


@Entity
public class Job implements Serializable{
    private static final long serializableVerionUID=6;
    @Id
    @GeneratedValue
    private int id;
    private String service;
    private Boolean etat;

    public Job() {
        super();
    }

    public Job(String service, Boolean etat) {
        this.service = service;
        this.etat = etat;
    }

    public String getService() {
        return service;
    }

    public Boolean getEtat() {
        return etat;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }
}
