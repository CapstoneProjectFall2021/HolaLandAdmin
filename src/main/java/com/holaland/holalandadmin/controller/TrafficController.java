package com.holaland.holalandadmin.controller;

import com.holaland.holalandadmin.entity.traffic.Bus;
import com.holaland.holalandadmin.entity.traffic.MotorbikeTaxiDrivers;
import com.holaland.holalandadmin.service.traffic.BusService;
import com.holaland.holalandadmin.service.traffic.MotorbikeTaxiDriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TrafficController {

    private final BusService busService;
    private final MotorbikeTaxiDriversService motorbikeTaxiDriversService;

    @Autowired
    public TrafficController(BusService busService, MotorbikeTaxiDriversService motorbikeTaxiDriversService) {
        this.busService = busService;
        this.motorbikeTaxiDriversService = motorbikeTaxiDriversService;
    }

    @GetMapping("/bus")
    public String bus(Model model) {
        List<Bus> busList = busService.getAll();
        model.addAttribute("busList",busList);
        model.addAttribute("page", 7);
        return "index";
    }

    @GetMapping("/bus/stop")
    public String busStop(@RequestParam("busId") int busId, Model model) {
        List<Bus> busList = busService.getAll();
        List<String> busStop = busService.getOne(busId).getTfBusStops();
        model.addAttribute("busList",busList);
        model.addAttribute("busStop",busStop);
        model.addAttribute("page", 7);
        return "index";
    }

    @GetMapping("/bus/delete")
    public String busDelete(@RequestParam("busId") int busId) {
        boolean isCheck = busService.delete(busId);
        return "redirect:" + "/bus";
    }

    @GetMapping("/motorbike-taxi-drivers")
    public String motorbikeTaxiDrivers(Model model) {
        List<MotorbikeTaxiDrivers> motorbikeTaxiDriversList = motorbikeTaxiDriversService.getAll();
        model.addAttribute("motorbikeTaxiDriversList",motorbikeTaxiDriversList);
        model.addAttribute("page", 8);
        return "index";
    }

    @GetMapping("/motorbike-taxi-drivers/delete")
    public String motorbikeTaxiDriversDelete(@RequestParam("motorbikeId") int motorbikeId) {
        boolean isCheck = motorbikeTaxiDriversService.delete(motorbikeId);
        return "redirect:" + "/motorbike-taxi-drivers";
    }
}
