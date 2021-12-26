package com.holaland.holalandadmin.controller;

import com.holaland.holalandadmin.entity.traffic.Bus;
import com.holaland.holalandadmin.entity.work.WorkRequestFindJob;
import com.holaland.holalandadmin.entity.work.WorkRequestRecruitment;
import com.holaland.holalandadmin.service.UserDetailService;
import com.holaland.holalandadmin.service.work.*;
import com.holaland.holalandadmin.util.Format;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("userDetailService",userDetailService);
        model.addAttribute("format", new Format());
        model.addAttribute("page", 4);
        return "index";
    }

    @GetMapping("/work/recruitment/detail")
    public String recruitmentDetail(@RequestParam("recruitmentId") int recruitmentId,Model model) {
        List<WorkRequestRecruitment> workList = workRequestRecruitmentService.getAll();
        WorkRequestRecruitment workRecruitment = workRequestRecruitmentService.getOne(recruitmentId);
        model.addAttribute("workList", workList);
        model.addAttribute("workRecruitment",workRecruitment);
        model.addAttribute("workPaymentMethodService",workPaymentMethodService);
        model.addAttribute("workRequestTypeService",workRequestTypeService);
        model.addAttribute("workSalaryUnitService",workSalaryUnitService);
        model.addAttribute("userDetailService",userDetailService);
        model.addAttribute("format", new Format());
        model.addAttribute("page", 4);
        return "index";
    }

    @GetMapping("/work/recruitment/approve")
    public String approveRequestRecruitment(@RequestParam("recruitmentId") int recruitmentId) {
        boolean isCheck = workRequestRecruitmentService.requestRecruitmentApprove(recruitmentId);
        return "redirect:" + "/work/recruitment";
    }

    @GetMapping("/work/recruitment/cancel")
    public String getFormCancelRecruitment(@RequestParam("recruitmentId") int recruitmentId, Model model) {
        List<WorkRequestRecruitment> workList = workRequestRecruitmentService.getAll();
        WorkRequestRecruitment recruitmentPost = workRequestRecruitmentService.getOne(recruitmentId);
        WorkRequestRecruitment cancelRequest = WorkRequestRecruitment.builder().build();

        model.addAttribute("workList", workList);
        model.addAttribute("recruitmentPost", recruitmentPost);
        model.addAttribute("cancelRequest", cancelRequest);
        model.addAttribute("userDetailService",userDetailService);
        model.addAttribute("format", new Format());
        model.addAttribute("page", 4);
        return "index";
    }

    @PostMapping("/work/recruitment/cancel")
    public String cancelRecruitment(@ModelAttribute("cancelRequest") WorkRequestRecruitment obj, BindingResult result) {
        if (result.hasErrors()){
            System.out.println("There was a error " + result);
            return null;
        }

        boolean isCheck = workRequestRecruitmentService.cancel(obj);
        if (isCheck) {
            return "redirect:" + "/work/recruitment";
        } else {
            return null;
        }
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
        model.addAttribute("userDetailService",userDetailService);
        model.addAttribute("format", new Format());
        model.addAttribute("page", 5);
        return "index";
    }

    @GetMapping("/work/find-job/detail")
    public String findJobDetail(@RequestParam("findJobId") int findJobId, Model model) {
        List<WorkRequestFindJob> workerList = workRequestFindJobService.getAll();
        WorkRequestFindJob workFindJob = workRequestFindJobService.getOne(findJobId);
        model.addAttribute("workerList", workerList);
        model.addAttribute("workFindJob", workFindJob);
        model.addAttribute("workPaymentMethodService",workPaymentMethodService);
        model.addAttribute("workRequestTypeService",workRequestTypeService);
        model.addAttribute("workSalaryUnitService",workSalaryUnitService);
        model.addAttribute("workTimeService",workTimeService);
        model.addAttribute("userDetailService",userDetailService);
        model.addAttribute("format", new Format());
        model.addAttribute("page", 5);
        return "index";
    }

    @GetMapping("/work/find-job/approve")
    public String approveRequestFindJob(@RequestParam("findJobId") int findJobId) {
        boolean isCheck = workRequestFindJobService.requestFindJobApprove(findJobId);
        return "redirect:" + "/work/find-job";
    }

    @GetMapping("/work/find-job/cancel")
    public String getFormCancelFindJob(@RequestParam("findJobId") int findJobId, Model model) {
        List<WorkRequestFindJob> workerList = workRequestFindJobService.getAll();
        WorkRequestFindJob findJobPost = workRequestFindJobService.getOne(findJobId);
        WorkRequestFindJob cancelRequest = WorkRequestFindJob.builder().build();

        model.addAttribute("workerList", workerList);
        model.addAttribute("findJobPost", findJobPost);
        model.addAttribute("cancelRequest", cancelRequest);
        model.addAttribute("userDetailService",userDetailService);
        model.addAttribute("format", new Format());
        model.addAttribute("page", 5);
        return "index";
    }

    @PostMapping("/work/find-job/cancel")
    public String cancelFindJob(@ModelAttribute("cancelRequest") WorkRequestFindJob obj, BindingResult result) {
        if (result.hasErrors()){
            System.out.println("There was a error " + result);
            return null;
        }

        boolean isCheck = workRequestFindJobService.cancel(obj);
        if (isCheck) {
            return "redirect:" + "/work/find-job";
        } else {
            return null;
        }
    }

    @GetMapping("/work/find-job/delete")
    public String deleteFindJob(@RequestParam("findJobId") int findJobId) {
        boolean isCheck = workRequestFindJobService.delete(findJobId);
        return "redirect:" + "/work/find-job";
    }
}
