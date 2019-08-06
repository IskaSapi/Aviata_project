package com.myspring.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER )
    private Users user_id;

    @ManyToOne(fetch = FetchType.EAGER )
    private Flights flights_id;

    private String name;

    private String surname;

    private int passport_no;

    private double price;

    private boolean isBusiness;

    private Date booked_time;

    public Tickets() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public Flights getFlights_id() {
        return flights_id;
    }

    public void setFlights_id(Flights flights_id) {
        this.flights_id = flights_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPassport_no() {
        return passport_no;
    }

    public void setPassport_no(int passport_no) {
        this.passport_no = passport_no;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBusiness() {
        return isBusiness;
    }

    public void setBusiness(boolean business) {
        isBusiness = business;
    }

    public Date getBooked_time() {
        return booked_time;
    }

    public void setBooked_time(Date booked_time) {
        this.booked_time = booked_time;
    }
}
