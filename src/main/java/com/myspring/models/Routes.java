package com.myspring.models;

import javax.persistence.*;

@Entity
@Table(name = "routes")
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER )
    private Cities departure_city_id;

    @ManyToOne(fetch = FetchType.EAGER )
    private Cities arrival_city_id;

    public Routes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cities getDeparture_city_id() {
        return departure_city_id;
    }

    public void setDeparture_city_id(Cities departure_city_id) {
        this.departure_city_id = departure_city_id;
    }

    public Cities getArrival_city_id() {
        return arrival_city_id;
    }

    public void setArrival_city_id(Cities arrival_city_id) {
        this.arrival_city_id = arrival_city_id;
    }
}
