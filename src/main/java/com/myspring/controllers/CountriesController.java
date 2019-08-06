package com.myspring.controllers;

import com.myspring.beans.CountriesBean;
import com.myspring.models.Aircrafts;
import com.myspring.models.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "countries")
public class CountriesController {

    @Autowired
    CountriesBean countriesBean;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request, @RequestParam String name, @RequestParam
            String short_name) {
        Countries country = new Countries();
        country.setName(name);
        country.setShort_name(short_name);
        countriesBean.addCountry(country);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(HttpServletRequest request, @PathVariable Long id){
        countriesBean.deletebyID(id);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
}
