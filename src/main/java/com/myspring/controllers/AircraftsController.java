package com.myspring.controllers;

import com.myspring.beans.AircraftsBean;
import com.myspring.models.Aircrafts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "air")
public class AircraftsController {
    @Autowired
    AircraftsBean aircraftsBean;


    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(HttpServletRequest request, @RequestParam String name,
                      @RequestParam String model,@RequestParam int business, @RequestParam int econom){
        Aircrafts aircrafts = new Aircrafts();
        aircrafts.setName(name);
        aircrafts.setModel(model);
        aircrafts.setBusiness_capacity(business);
        aircrafts.setEconom_capacity(econom);
        aircraftsBean.addAircraft(aircrafts);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(HttpServletRequest request, @PathVariable Long id){
        aircraftsBean.deletebyID(id);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

}
