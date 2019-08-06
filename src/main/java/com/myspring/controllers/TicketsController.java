package com.myspring.controllers;

import com.myspring.beans.FlightsBean;
import com.myspring.beans.TicketsBean;
import com.myspring.models.Flights;
import com.myspring.models.Tickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "tickets")
public class TicketsController {


    @Autowired
    TicketsBean ticketsBean;
    @Autowired
    FlightsBean flightsBean;

    @RequestMapping(value = "")
    public ModelAndView tickets(){
        ModelAndView mw = new ModelAndView();
        mw.addObject("tickets");
        List<Flights> flights = flightsBean.getAllFlights();
        List<Tickets> ticket = ticketsBean.getAllTickets();
        mw.addObject("flights",flights);
        mw.addObject("ticket",ticket);
        return mw;
    }
    @RequestMapping(value = "/add")
    public String  add(HttpServletRequest request, @RequestParam String name, @RequestParam String surname, @RequestParam
                            int pasport, @RequestParam Long fly_id, @RequestParam String bus){
        ModelAndView mw = new ModelAndView();
        Tickets tickets = new Tickets();
        tickets.setName(name);
        tickets.setSurname(surname);
        tickets.setPassport_no(pasport);
        Flights flights = flightsBean.getFlightById(fly_id);
        if(bus.equals("econom")) {
            flights.getAircrafts_id().setEconom_capacity(flights.getAircrafts_id().getEconom_capacity()-1);
            tickets.setBusiness(false);
        }
        else {
            flights.getAircrafts_id().setEconom_capacity(flights.getAircrafts_id().getBusiness_capacity()-1);
            tickets.setBusiness(true);
        }


       tickets.setFlights_id(flights);

        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formatted_date = dateFormat.format(date);
        tickets.setBooked_time(java.sql.Date.valueOf(formatted_date));


        ticketsBean.addTickets(tickets);

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
