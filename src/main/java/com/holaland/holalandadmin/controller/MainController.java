package com.holaland.holalandadmin.controller;

import com.holaland.holalandadmin.entity.UserDetail;
import com.holaland.holalandadmin.entity.food.FoodReport;
import com.holaland.holalandadmin.entity.food.FoodStoreOnline;
import com.holaland.holalandadmin.entity.food.FoodStoreOnlineRate;
import com.holaland.holalandadmin.repository.UserRepository;
import com.holaland.holalandadmin.service.food.FoodReportService;
import com.holaland.holalandadmin.service.food.FoodStoreOnlineRateService;
import com.holaland.holalandadmin.service.food.FoodStoreOnlineService;
import com.holaland.holalandadmin.service.UserDetailService;
import com.holaland.holalandadmin.service.UserRoleService;
import com.holaland.holalandadmin.service.UserService;
import com.holaland.holalandadmin.util.Format;
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
    private final UserRoleService userRoleService;
    private final FoodReportService foodReportService;
    private final FoodStoreOnlineRateService foodStoreOnlineRateService;

    @Autowired
    public MainController(
            UserRepository userRepository,
            UserDetailService userDetailService,
            FoodStoreOnlineService foodStoreOnlineService,
            UserService userService,
            UserRoleService userRoleService,
            FoodReportService foodReportService,
            FoodStoreOnlineRateService foodStoreOnlineRateService
    ){
        this.userRepository = userRepository;
        this.userDetailService = userDetailService;
        this.foodStoreOnlineService = foodStoreOnlineService;
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.foodReportService = foodReportService;
        this.foodStoreOnlineRateService = foodStoreOnlineRateService;
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
        model.addAttribute("userService", userService);
        model.addAttribute("userRoleService", userRoleService);
        model.addAttribute("format", new Format());
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

    @GetMapping("/user/all/unlock")
    public String unlockUser(
            @RequestParam("userId") int userId,
            @RequestParam("status") Integer status
    ) {
        boolean isCheck = userService.unlock(userId);
        if (isCheck) {
            return "redirect:" + "/user/all?status=" + status;
        } else {
            return null;
        }
    }

    @GetMapping("/user/all/lock")
    public String lockUser(
            @RequestParam("userId") int userId,
            @RequestParam("status") Integer status
    ) {
        boolean isCheck = userService.lock(userId);
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

    @GetMapping("/food/online-store/lock")
    public String lockOnlineStore(@RequestParam("onlineStoreId") int onlineStoreId) {
        boolean isCheck = foodStoreOnlineService.lock(onlineStoreId);
        if (isCheck) {
            return "redirect:" + "/food/online-store";
        } else {
            return null;
        }
    }

    @GetMapping("/food/online-store/unlock")
    public String unlockOnlineStore(@RequestParam("onlineStoreId") int onlineStoreId) {
        boolean isCheck = foodStoreOnlineService.unlock(onlineStoreId);
        if (isCheck) {
            return "redirect:" + "/food/online-store";
        } else {
            return null;
        }
    }

    @GetMapping("/food/online-store/comment")
    public String showComment(@RequestParam("onlineStoreId") int onlineStoreId, Model model) {
        List<FoodStoreOnlineRate> listComment = foodStoreOnlineRateService.getAllCommentByStoreOnlineId(onlineStoreId);
        List<FoodStoreOnline> storeOnlineList = foodStoreOnlineService.getAll();

        model.addAttribute("storeOnlineList", storeOnlineList);
        model.addAttribute("listComment", listComment);
        model.addAttribute("userDetailService", userDetailService);
        model.addAttribute("page", 6);
        return "index";
    }

    @GetMapping("/food/online-store/report")
    public String showReport(@RequestParam("onlineStoreId") int onlineStoreId, Model model) {
        List<FoodReport> listReport = foodReportService.getAllByStoreOnlineId(onlineStoreId);
        List<FoodStoreOnline> storeOnlineList = foodStoreOnlineService.getAll();

        model.addAttribute("storeOnlineList", storeOnlineList);
        model.addAttribute("listReport", listReport);
        model.addAttribute("userDetailService", userDetailService);
        model.addAttribute("page", 6);
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
