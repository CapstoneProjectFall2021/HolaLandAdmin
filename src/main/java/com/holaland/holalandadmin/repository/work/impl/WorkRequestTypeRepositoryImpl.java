package com.holaland.holalandadmin.repository.work.impl;

import com.holaland.holalandadmin.entity.work.WorkRequestType;
import com.holaland.holalandadmin.mapper.work.WorkRequestTypeMapper;
import com.holaland.holalandadmin.repository.work.IRepositoryQuery;
import com.holaland.holalandadmin.repository.work.WorkRequestTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WorkRequestTypeRepositoryImpl implements WorkRequestTypeRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkRequestTypeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public WorkRequestType getOne(int id) throws DataAccessException {
        return jdbcTemplate.queryForObject(WORK_REQUEST_TYPE_GET_ONE, new WorkRequestTypeMapper(), id);
    }
}
