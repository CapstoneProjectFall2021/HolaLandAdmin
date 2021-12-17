package com.holaland.holalandadmin.service.work.impl;

import com.holaland.holalandadmin.entity.work.WorkRequestRecruitment;
import com.holaland.holalandadmin.repository.work.WorkRequestRecruitmentRepository;
import com.holaland.holalandadmin.service.work.WorkRequestRecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkRequestRecruitmentServiceImpl implements WorkRequestRecruitmentService {

    private final WorkRequestRecruitmentRepository workRequestRecruitmentRepository;

    @Autowired
    public WorkRequestRecruitmentServiceImpl(WorkRequestRecruitmentRepository workRequestRecruitmentRepository) {
        this.workRequestRecruitmentRepository = workRequestRecruitmentRepository;
    }


    @Override
    public List<WorkRequestRecruitment> getAll() throws DataAccessException {
        return workRequestRecruitmentRepository.getAll();
    }

    @Override
    public WorkRequestRecruitment getOne(int id) throws DataAccessException {
        return workRequestRecruitmentRepository.getOne(id);
    }

    @Override
    public boolean requestRecruitmentApprove(int id) throws DataAccessException {
        return workRequestRecruitmentRepository.requestRecruitmentApprove(id);
    }

    @Override
    public boolean delete(int id) throws DataAccessException {
        return workRequestRecruitmentRepository.delete(id);
    }
}
