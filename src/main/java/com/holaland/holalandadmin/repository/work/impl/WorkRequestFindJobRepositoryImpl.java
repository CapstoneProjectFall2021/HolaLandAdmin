package com.holaland.holalandadmin.repository.work.impl;

import com.holaland.holalandadmin.entity.work.WorkRequestFindJob;
import com.holaland.holalandadmin.mapper.work.WorkRequestFindJobMapper;
import com.holaland.holalandadmin.repository.work.IRepositoryQuery;
import com.holaland.holalandadmin.repository.work.WorkRequestFindJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkRequestFindJobRepositoryImpl implements WorkRequestFindJobRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkRequestFindJobRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<WorkRequestFindJob> getAll() throws DataAccessException {
        return jdbcTemplate.query(WORK_REQUEST_FIND_JOB_GET_ALL, new WorkRequestFindJobMapper());
    }

    @Override
    public WorkRequestFindJob getOne(int id) throws DataAccessException {
        return jdbcTemplate.queryForObject(WORK_REQUEST_FIND_JOB_GET_ONE, new WorkRequestFindJobMapper(), id);
    }

    @Override
    public boolean delete(int id) throws DataAccessException {
        return jdbcTemplate.update(WORK_REQUEST_FIND_JOB_DELETED_ONE, id) > 0;
    }
}
