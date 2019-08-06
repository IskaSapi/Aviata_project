package com.myspring.controllers;

import com.myspring.beans.AircraftsBean;
import com.myspring.beans.FlightsBean;
import com.myspring.beans.RoutesBean;
import com.myspring.models.Aircrafts;
import com.myspring.models.Cities;
import com.myspring.models.Flights;
import com.myspring.models.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(path = "fly")
public class FlightsController {
    @Autowired
    FlightsBean flightsBean;

    @Autowired
    AircraftsBean aircraftsBean;

    @Autowired
    RoutesBean routesBean;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request, @RequestParam Long aircraft_id,
                      @RequestParam  Long route_id, @RequestParam String date) {
        Flights flights = new Flights();

        Routes routes = new Routes();
         routes = routesBean.getRouteById(route_id);

        Aircrafts aircrafts = new Aircrafts();
        aircrafts = aircraftsBean.getAircraftById(aircraft_id);




        flights.setAircrafts_id(aircrafts);
        flights.setRoutes_id(routes);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date parsed = null;
        try{
            parsed = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        flights.setDeparture_time(parsed);

        flightsBean.addFlight(flights);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(HttpServletRequest request, @PathVariable Long id){
        flightsBean.deletebyID(id);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }






}
