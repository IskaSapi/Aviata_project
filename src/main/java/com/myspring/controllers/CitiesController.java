package com.myspring.controllers;

import com.myspring.beans.CitiesBean;
import com.myspring.beans.CountriesBean;
import com.myspring.models.Aircrafts;
import com.myspring.models.Cities;
import com.myspring.models.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "city")
public class CitiesController {
    @Autowired
    CitiesBean citiesBean;

    @Autowired
    CountriesBean countriesBean;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request, @RequestParam String name, @RequestParam
            String short_name,@RequestParam Long country_id) {
        Countries countries = countriesBean.getCountryById(country_id);
        Cities cities = new Cities();
        cities.setName(name);
        cities.setShort_name(short_name);
        cities.setCountries(countries);
        citiesBean.addCity(cities);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(HttpServletRequest request, @PathVariable Long id){
        citiesBean.deletebyID(id);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
}
