package com.myspring.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prices")
public class Prices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne
    Flights flight;

    private Double econom_value;

    private Double business_value;

    private Date assigned_time;

    public Prices() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flights getFlight() {
        return flight;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }

    public Double getEconom_value() {
        return econom_value;
    }

    public void setEconom_value(Double econom_value) {
        this.econom_value = econom_value;
    }

    public Double getBusiness_value() {
        return business_value;
    }

    public void setBusiness_value(Double business_value) {
        this.business_value = business_value;
    }

    public Date getAssigned_time() {
        return assigned_time;
    }

    public void setAssigned_time(Date assigned_time) {
        this.assigned_time = assigned_time;
    }
}
