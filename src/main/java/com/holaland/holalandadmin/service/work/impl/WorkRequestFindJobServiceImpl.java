package com.holaland.holalandadmin.service.work.impl;

import com.holaland.holalandadmin.entity.work.WorkRequestFindJob;
import com.holaland.holalandadmin.repository.work.WorkRequestFindJobRepository;
import com.holaland.holalandadmin.service.work.WorkRequestFindJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkRequestFindJobServiceImpl implements WorkRequestFindJobService {

    private final WorkRequestFindJobRepository workRequestFindJobRepository;

    @Autowired
    public WorkRequestFindJobServiceImpl(WorkRequestFindJobRepository workRequestFindJobRepository) {
        this.workRequestFindJobRepository = workRequestFindJobRepository;
    }

    @Override
    public List<WorkRequestFindJob> getAll() throws DataAccessException {
        return workRequestFindJobRepository.getAll();
    }

    @Override
    public WorkRequestFindJob getOne(int id) throws DataAccessException {
        return workRequestFindJobRepository.getOne(id);
    }

    @Override
    public boolean delete(int id) throws DataAccessException {
        return workRequestFindJobRepository.delete(id);
    }
}
