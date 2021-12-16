package com.holaland.holalandadmin.repository.work.impl;

import com.holaland.holalandadmin.entity.work.WorkSalaryUnit;
import com.holaland.holalandadmin.mapper.work.WorkSalaryUnitMapper;
import com.holaland.holalandadmin.repository.work.IRepositoryQuery;
import com.holaland.holalandadmin.repository.work.WorkSalaryUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WorkSalaryUnitRepositoryImpl implements WorkSalaryUnitRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkSalaryUnitRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public WorkSalaryUnit getOne(int id) throws DataAccessException {
        return jdbcTemplate.queryForObject(WORK_SALARY_UNIT_GET_ONE, new WorkSalaryUnitMapper(), id);
    }
}
