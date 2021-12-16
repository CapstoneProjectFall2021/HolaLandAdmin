package com.holaland.holalandadmin.repository.work.impl;

import com.holaland.holalandadmin.entity.work.WorkTime;
import com.holaland.holalandadmin.mapper.work.WorkTimeMapper;
import com.holaland.holalandadmin.repository.work.IRepositoryQuery;
import com.holaland.holalandadmin.repository.work.WorkTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WorkTimeRepositoryImpl implements WorkTimeRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkTimeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public WorkTime getOne(int id) throws DataAccessException {
        return jdbcTemplate.queryForObject(WORK_TIME_GET_ONE, new WorkTimeMapper(), id);
    }
}
