package com.holaland.holalandadmin.service.work.impl;

import com.holaland.holalandadmin.entity.work.WorkTime;
import com.holaland.holalandadmin.repository.work.WorkTimeRepository;
import com.holaland.holalandadmin.service.work.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class WorkTimeServiceImpl implements WorkTimeService {

    private final WorkTimeRepository workTimeRepository;

    @Autowired
    public WorkTimeServiceImpl(WorkTimeRepository workTimeRepository) {
        this.workTimeRepository = workTimeRepository;
    }

    @Override
    public WorkTime getOne(int id) throws DataAccessException {
        return workTimeRepository.getOne(id);
    }
}
