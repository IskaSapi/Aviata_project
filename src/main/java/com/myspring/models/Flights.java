package com.myspring.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "flights")
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne
    private Routes routes_id;

    private Date departure_time;

    @ManyToOne
    private Aircrafts aircrafts_id;

    public Flights() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Routes getRoutes_id() {
        return routes_id;
    }

    public void setRoutes_id(Routes routes_id) {
        this.routes_id = routes_id;
    }

    public Date getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Date departure_time) {
        this.departure_time = departure_time;
    }

    public Aircrafts getAircrafts_id() {
        return aircrafts_id;
    }

    public void setAircrafts_id(Aircrafts aircrafts_id) {
        this.aircrafts_id = aircrafts_id;
    }
}
