package com.myspring.models;

import javax.persistence.*;

@Entity
@Table(name = "aircrafts")
public class Aircrafts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private String model;

    public Aircrafts(String name, String model, int econom_capacity, int business_capacity) {
        this.name = name;
        this.model = model;
        this.econom_capacity = econom_capacity;
        this.business_capacity = business_capacity;
    }

    private int econom_capacity;

    private int business_capacity;

    public Aircrafts() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEconom_capacity() {
        return econom_capacity;
    }

    public void setEconom_capacity(int econom_capacity) {
        this.econom_capacity = econom_capacity;
    }

    public int getBusiness_capacity() {
        return business_capacity;
    }

    public void setBusiness_capacity(int business_capacity) {
        this.business_capacity = business_capacity;
    }
}
