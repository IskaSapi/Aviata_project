package com.myspring.controllers;


import com.myspring.beans.*;
import com.myspring.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    RoleBean roleBean;

    @Autowired
    UserBean userBean;

    @Autowired
    AircraftsBean aircraftsBean;

    @Autowired
    CountriesBean countriesBean;

    @Autowired
    CitiesBean citiesBean;

    @Autowired
    RoutesBean routesBean;

    @Autowired
    FlightsBean flightsBean;


    @Autowired
    PricesBean pricesBean;

    @RequestMapping(value = {"enter", "/"})
    public ModelAndView indexPage() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView mw = new ModelAndView("regist");
        return mw;
    }

    @PostMapping(value = "/register")
    public String registration(@RequestParam String login, @RequestParam String password,@RequestParam String full_name, HttpServletRequest request) {
        Users user = new Users();
        user.setLogin(login);
        user.setPassword(stringToMD5(password));
        user.setFull_name(full_name);
        Roles role = roleBean.getRole(Roles.ROLE_USER);
        user.setRoles(new ArrayList<Roles>());
        user.getRoles().add(role);
        userBean.addUser(user);
        return "redirect: /";
    }

    @RequestMapping(value = "/aircrafts")
    public ModelAndView aircrafts(){
        ModelAndView mw = new ModelAndView();
        mw.addObject("aircrafts");
        List<Aircrafts> aircraftsList = aircraftsBean.getAllAircrafts();
        mw.addObject("aircraftList",aircraftsList);
        return mw;
    }

    @RequestMapping(value = "/cities")
    public ModelAndView cities(){
        ModelAndView mw = new ModelAndView();
        mw.addObject("cities");
        List<Cities> cities = citiesBean.getAllCities();
        List<Countries> countries = countriesBean.getAllCountries();
        mw.addObject("countries",countries);
        mw.addObject("cities",cities);
        return mw;
    }

    @RequestMapping(value = "/routes")
    public ModelAndView routes(){
        ModelAndView mw = new ModelAndView();
        mw.addObject("routes");
        List<Cities> cities = citiesBean.getAllCities();
        List<Routes> routes = routesBean.getAllRoutes();
        mw.addObject("cities",cities);
        mw.addObject("routes",routes);
        return mw;
    }



    @RequestMapping(value = "/flights")
    public ModelAndView flights(){
        ModelAndView mw = new ModelAndView();
        mw.addObject("flights");
        List<Flights> flights = flightsBean.getAllFlights();
        List<Routes> routes = routesBean.getAllRoutes();
        List<Aircrafts> aircrafts = aircraftsBean.getAllAircrafts();
        mw.addObject("aircrafts",aircrafts);
        mw.addObject("flights",flights);
        mw.addObject("routes",routes);
        return mw;
    }


//    @RequestMapping(value = "/tickets")
//    public ModelAndView tickets(){
//        ModelAndView mw = new ModelAndView();
//        mw.addObject("tickets");
//        List<Flights> flights = flightsBean.getAllFlights();
//        mw.addObject("flights",flights);
//        return mw;
//    }


    @RequestMapping(value = "/prices")
    public ModelAndView prices(){
        ModelAndView mw = new ModelAndView();
        mw.addObject("prices");
        List<Flights> flights = flightsBean.getAllFlights();
        List<Prices> prices = pricesBean.getAllPrices();
        mw.addObject("flights",flights);
        mw.addObject("price",prices);
        return mw;
    }

    @RequestMapping(value = "/countries")
    public ModelAndView countries(){
        ModelAndView mw = new ModelAndView();
        mw.addObject("countries");
        List<Countries> countries = countriesBean.getAllCountries();
        mw.addObject("countries",countries);
        return mw;
    }


    public static String stringToMD5(String input) {
        String res = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] result = messageDigest.digest(input.getBytes("UTF-8"));
            res = (new String(Hex.encode(result)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }




}

