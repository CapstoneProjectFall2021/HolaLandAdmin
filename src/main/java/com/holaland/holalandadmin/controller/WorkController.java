package com.holaland.holalandadmin.controller;

import com.holaland.holalandadmin.entity.work.WorkRequestFindJob;
import com.holaland.holalandadmin.entity.work.WorkRequestRecruitment;
import com.holaland.holalandadmin.service.UserDetailService;
import com.holaland.holalandadmin.service.work.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WorkController {

    private final WorkRequestRecruitmentService workRequestRecruitmentService;
    private final WorkRequestFindJobService workRequestFindJobService;
    private final SttWorkService sttWorkService;
    private final WorkPaymentMethodService workPaymentMethodService;
    private final WorkRequestTypeService workRequestTypeService;
    private final WorkSalaryUnitService workSalaryUnitService;
    private final WorkTimeService workTimeService;
    private final UserDetailService userDetailService;

    public WorkController(WorkRequestRecruitmentService workRequestRecruitmentService,
                          WorkRequestFindJobService workRequestFindJobService,
                          SttWorkService sttWorkService,
                          WorkPaymentMethodService workPaymentMethodService,
                          WorkRequestTypeService workRequestTypeService,
                          WorkSalaryUnitService workSalaryUnitService,
                          WorkTimeService workTimeService, UserDetailService userDetailService) {
        this.workRequestRecruitmentService = workRequestRecruitmentService;
        this.workRequestFindJobService = workRequestFindJobService;
        this.sttWorkService = sttWorkService;
        this.workPaymentMethodService = workPaymentMethodService;
        this.workRequestTypeService = workRequestTypeService;
        this.workSalaryUnitService = workSalaryUnitService;
        this.workTimeService = workTimeService;
        this.userDetailService = userDetailService;
    }

    @GetMapping("/work/recruitment")
    public String recruitment(Model model) {
        List<WorkRequestRecruitment> workList = workRequestRecruitmentService.getAll();
        model.addAttribute("workList", workList);
        model.addAttribute("workPaymentMethodService",workPaymentMethodService);
        model.addAttribute("workRequestTypeService",workRequestTypeService);
        model.addAttribute("workSalaryUnitService",workSalaryUnitService);
        model.addAttribute("workTimeService",workTimeService);
        model.addAttribute("userDetailService",userDetailService);
        model.addAttribute("page", 4);
        return "index";
    }

    @GetMapping("/work/recruitment/delete")
    public String deleteRecruitment(@RequestParam("recruitmentId") int recruitmentId) {
        boolean isCheck = workRequestRecruitmentService.delete(recruitmentId);
        return "redirect:" + "/work/recruitment";
    }

    @GetMapping("/work/find-job")
    public String findJob(Model model) {
        List<WorkRequestFindJob> workerList = workRequestFindJobService.getAll();
        model.addAttribute("workerList", workerList);
        model.addAttribute("workPaymentMethodService",workPaymentMethodService);
        model.addAttribute("workRequestTypeService",workRequestTypeService);
        model.addAttribute("workSalaryUnitService",workSalaryUnitService);
        model.addAttribute("workTimeService",workTimeService);
        model.addAttribute("userDetailService",userDetailService);
        model.addAttribute("page", 5);
        return "index";
    }

    @GetMapping("/work/find-job/delete")
    public String deleteFindJob(@RequestParam("findJobId") int findJobId) {
        boolean isCheck = workRequestFindJobService.delete(findJobId);
        return "redirect:" + "/work/find-job";
    }
}
