package com.holaland.holalandadmin.controller;

import com.holaland.holalandadmin.entity.fptu.Club;
import com.holaland.holalandadmin.service.fptu.ClubService;
import com.holaland.holalandadmin.service.fptu.ClubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FPTUniversityController {

    private final ClubService clubService;
    private final ClubTypeService clubTypeService;

    @Autowired
    public FPTUniversityController(ClubService clubService, ClubTypeService clubTypeService) {
        this.clubService = clubService;
        this.clubTypeService = clubTypeService;
    }

    @GetMapping("/club/all")
    public String club(Model model) {
        List<Club> clubList = clubService.getAll();
        model.addAttribute("clubList", clubList);
        model.addAttribute("clubTypeService", clubTypeService);
        model.addAttribute("page", 3);
        return "index";
    }
}
