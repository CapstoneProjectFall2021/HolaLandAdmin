package com.holaland.holalandadmin.controller;

import com.holaland.holalandadmin.entity.traffic.Bus;
import com.holaland.holalandadmin.entity.traffic.MotorbikeTaxiDrivers;
import com.holaland.holalandadmin.service.traffic.BusService;
import com.holaland.holalandadmin.service.traffic.MotorbikeTaxiDriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Binding;
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
        Bus addBus = Bus.builder().build();

        model.addAttribute("addBus", addBus);
        model.addAttribute("busList",busList);
        model.addAttribute("page", 7);
        return "index";
    }

    @GetMapping("/bus/stop")
    public String busStop(@RequestParam("busId") int busId, Model model) {
        List<Bus> busList = busService.getAll();
        List<String> busStop = busService.getOne(busId).getTfBusStops();
        Bus addBus = Bus.builder().build();

        model.addAttribute("addBus", addBus);
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

    @GetMapping("/bus/update")
    public String getFormUpdateBus(@RequestParam("busId") int busId, Model model) {
        List<Bus> busList = busService.getAll();
        Bus currentBus = busService.getOne(busId);
        Bus updateBus = Bus.builder().build();
        Bus addBus = Bus.builder().build();

        model.addAttribute("addBus", addBus);
        model.addAttribute("busList",busList);
        model.addAttribute("currentBus", currentBus);
        model.addAttribute("updateBus", updateBus);
        model.addAttribute("page", 7);
        return "index";
    }

    @PostMapping("/bus/update")
    public String updateBus(@ModelAttribute("updateBus") Bus obj, BindingResult result) {
        if (result.hasErrors()){
            System.out.println("There was a error " + result);
            return null;
        }

        boolean isCheck = busService.update(obj);
        if (isCheck) {
            return "redirect:" + "/bus";
        } else {
            return null;
        }
    }

    @PostMapping("/bus/add")
    public String addNewBus(@ModelAttribute("addBus") Bus obj, BindingResult result) {
        if (result.hasErrors()){
            System.out.println("There was a error " + result);
            return null;
        }

        boolean isCheck = busService.add(obj);
        if (isCheck) {
            return "redirect:" + "/bus";
        } else {
            return null;
        }
    }

    @GetMapping("/motorbike-taxi-drivers")
    public String motorbikeTaxiDrivers(Model model) {
        List<MotorbikeTaxiDrivers> motorbikeTaxiDriversList = motorbikeTaxiDriversService.getAll();
        MotorbikeTaxiDrivers addDriver = MotorbikeTaxiDrivers.builder().build();

        model.addAttribute("addDriver", addDriver);
        model.addAttribute("motorbikeTaxiDriversList",motorbikeTaxiDriversList);
        model.addAttribute("page", 8);
        return "index";
    }

    @GetMapping("/motorbike-taxi-drivers/delete")
    public String motorbikeTaxiDriversDelete(@RequestParam("motorbikeId") int motorbikeId) {
        boolean isCheck = motorbikeTaxiDriversService.delete(motorbikeId);
        return "redirect:" + "/motorbike-taxi-drivers";
    }

    @GetMapping("/motorbike-taxi-drivers/update")
    public String getFormUpdateDriver(@RequestParam("driverId") int driverId, Model model) {
        List<MotorbikeTaxiDrivers> motorbikeTaxiDriversList = motorbikeTaxiDriversService.getAll();
        MotorbikeTaxiDrivers currentDriver = motorbikeTaxiDriversService.getOne(driverId);
        MotorbikeTaxiDrivers updateDriver = MotorbikeTaxiDrivers.builder().build();
        MotorbikeTaxiDrivers addDriver = MotorbikeTaxiDrivers.builder().build();

        model.addAttribute("addDriver", addDriver);
        model.addAttribute("motorbikeTaxiDriversList",motorbikeTaxiDriversList);
        model.addAttribute("currentDriver", currentDriver);
        model.addAttribute("updateDriver", updateDriver);
        model.addAttribute("page", 8);
        return "index";
    }

    @PostMapping("/motorbike-taxi-drivers/update")
    public String updateDriver(@ModelAttribute("updateDriver") MotorbikeTaxiDrivers obj, BindingResult result) {
        if (result.hasErrors()){
            System.out.println("There was a error " + result);
            return null;
        }

        boolean isCheck = motorbikeTaxiDriversService.update(obj);
        if (isCheck) {
            return "redirect:" + "/motorbike-taxi-drivers";
        } else {
            return null;
        }
    }

    @PostMapping("/motorbike-taxi-drivers/add")
    public String addDriver(@ModelAttribute("addDriver") MotorbikeTaxiDrivers obj, BindingResult result) {
        if (result.hasErrors()){
            System.out.println("There was a error " + result);
            return null;
        }

        boolean isCheck = motorbikeTaxiDriversService.add(obj);
        if (isCheck) {
            return "redirect:" + "/motorbike-taxi-drivers";
        } else {
            return null;
        }
    }
}
