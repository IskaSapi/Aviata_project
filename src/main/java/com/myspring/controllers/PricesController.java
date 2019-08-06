package com.myspring.controllers;

import com.myspring.beans.FlightsBean;
import com.myspring.beans.PricesBean;
import com.myspring.models.Cities;
import com.myspring.models.Flights;
import com.myspring.models.Prices;
import com.myspring.models.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.krb5.internal.PAData;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping(path = "price")
public class PricesController {
    @Autowired
    FlightsBean flightsBean;

    @Autowired
    PricesBean pricesBean;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request, @RequestParam Long flight_id,
                      @RequestParam  Double econom, @RequestParam Double business) {
        Flights flights = flightsBean.getFlightById(flight_id);
        Prices prices = new Prices();
        prices.setFlight(flights);
        prices.setBusiness_value(business);
        prices.setEconom_value(econom);

        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formatted_date = dateFormat.format(date);
        prices.setAssigned_time(java.sql.Date.valueOf(formatted_date));

        pricesBean.addPrice(prices);

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(HttpServletRequest request, @PathVariable Long id){
        Prices prices = pricesBean.getPriceById(id);
        pricesBean.deletePrice(prices);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

}
