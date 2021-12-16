package com.holaland.holalandadmin.service.work.impl;

import com.holaland.holalandadmin.entity.work.WorkSalaryUnit;
import com.holaland.holalandadmin.repository.work.WorkSalaryUnitRepository;
import com.holaland.holalandadmin.service.work.WorkSalaryUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class WorkSalaryUnitServiceImpl implements WorkSalaryUnitService {

    private final WorkSalaryUnitRepository workSalaryUnitRepository;

    @Autowired
    public WorkSalaryUnitServiceImpl(WorkSalaryUnitRepository workSalaryUnitRepository) {
        this.workSalaryUnitRepository = workSalaryUnitRepository;
    }

    @Override
    public WorkSalaryUnit getOne(int id) throws DataAccessException {
        return workSalaryUnitRepository.getOne(id);
    }
}
