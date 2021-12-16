package com.holaland.holalandadmin.service.work.impl;

import com.holaland.holalandadmin.entity.work.WorkRequestType;
import com.holaland.holalandadmin.repository.work.WorkRequestTypeRepository;
import com.holaland.holalandadmin.service.work.WorkRequestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class WorkRequestTypeServiceImpl implements WorkRequestTypeService {

    private final WorkRequestTypeRepository workRequestTypeRepository;

    @Autowired
    public WorkRequestTypeServiceImpl(WorkRequestTypeRepository workRequestTypeRepository) {
        this.workRequestTypeRepository = workRequestTypeRepository;
    }

    @Override
    public WorkRequestType getOne(int id) throws DataAccessException {
        return workRequestTypeRepository.getOne(id);
    }
}
