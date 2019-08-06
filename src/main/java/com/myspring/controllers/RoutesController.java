package com.myspring.controllers;

import com.myspring.beans.CitiesBean;
import com.myspring.beans.RoutesBean;
import com.myspring.models.Cities;
import com.myspring.models.Countries;
import com.myspring.models.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "route")
public class RoutesController {
    @Autowired
    CitiesBean citiesBean;
    @Autowired
    RoutesBean routesBean;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request, @RequestParam Long city_arr,
                      @RequestParam  Long city_dest) {
        Cities arrival = citiesBean.getCityById(city_arr);
        Cities dest = citiesBean.getCityById(city_dest);
        Routes routes = new Routes();
        routes.setArrival_city_id(arrival);
        routes.setDeparture_city_id(dest);
        routesBean.addRoute(routes);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(HttpServletRequest request, @PathVariable Long id){
        routesBean.deletebyID(id);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

}
