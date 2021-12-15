package com.holaland.holalandadmin.controller;

import com.holaland.holalandadmin.entity.UserDetail;
import com.holaland.holalandadmin.repository.UserRepository;
import com.holaland.holalandadmin.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainController {

    private final UserRepository userRepository;
    private final UserDetailService userDetailService;

    @Autowired
    public MainController(
            UserRepository userRepository,
            UserDetailService userDetailService
    ){
        this.userRepository = userRepository;
        this.userDetailService = userDetailService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("page", 1);
        return "index";
    }

    @GetMapping("/user/all")
    public String user(Model model) {
        List<UserDetail> getAllUserInfo = userDetailService.getAllUserInfo();

        model.addAttribute("getAllUserInfo", getAllUserInfo);
        model.addAttribute("page", 2);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "login";
    }
}
