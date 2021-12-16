package com.holaland.holalandadmin.controller;

import com.holaland.holalandadmin.entity.UserDetail;
import com.holaland.holalandadmin.entity.food.FoodStoreOnline;
import com.holaland.holalandadmin.repository.UserRepository;
import com.holaland.holalandadmin.service.FoodStoreOnlineService;
import com.holaland.holalandadmin.service.UserDetailService;
import com.holaland.holalandadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainController {

    private final UserRepository userRepository;
    private final UserDetailService userDetailService;
    private final FoodStoreOnlineService foodStoreOnlineService;
    private final UserService userService;

    @Autowired
    public MainController(
            UserRepository userRepository,
            UserDetailService userDetailService,
            FoodStoreOnlineService foodStoreOnlineService,
            UserService userService
    ){
        this.userRepository = userRepository;
        this.userDetailService = userDetailService;
        this.foodStoreOnlineService = foodStoreOnlineService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("page", 1);
        return "index";
    }

    @GetMapping("/user/all")
    public String user(@RequestParam("status") Integer status, Model model) {
        List<UserDetail> getInfo;
        if (status == 0){
            getInfo = userDetailService.getAllUserInfo(1,2,3,4);
        } else {
            getInfo = userDetailService.getAllUserInfo(status);
        }

        model.addAttribute("getAllUserInfo", getInfo);
        model.addAttribute("status", status);
        model.addAttribute("page", 2);
        return "index";
    }

    @GetMapping("/user/all/delete")
    public String deleteUser(
            @RequestParam("userId") int userId,
            @RequestParam("status") Integer status
    ) {
        boolean isCheck = userService.delete(userId);
        if (isCheck) {
            return "redirect:" + "/user/all?status=" + status;
        } else {
            return null;
        }
    }

    @GetMapping("/food/online-store")
    public String onlineStore(Model model) {
        List<FoodStoreOnline> storeOnlineList = foodStoreOnlineService.getAll();

        model.addAttribute("storeOnlineList", storeOnlineList);
        model.addAttribute("page", 6);
        return "index";
    }

    @GetMapping("food/online-store/delete")
    public String deleteOnlineStore(@RequestParam("onlineStoreId") int onlineStoreId) {
        boolean isCheck = foodStoreOnlineService.delete(onlineStoreId);
        if (isCheck) {
            return "redirect:" + "/food/online-store";
        } else {
            return null;
        }
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
