package com.holaland.holalandadmin.repository.work.impl;

import com.holaland.holalandadmin.entity.work.WorkRequestRecruitment;
import com.holaland.holalandadmin.mapper.work.WorkRequestRecruitmentMapper;
import com.holaland.holalandadmin.repository.work.IRepositoryQuery;
import com.holaland.holalandadmin.repository.work.WorkRequestRecruitmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkRequestRecruitmentRepositoryImpl implements WorkRequestRecruitmentRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkRequestRecruitmentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<WorkRequestRecruitment> getAll() throws DataAccessException {
        return jdbcTemplate.query(WORK_REQUEST_RECRUITMENT_GET_ALL, new WorkRequestRecruitmentMapper());
    }

    @Override
    public WorkRequestRecruitment getOne(int id) throws DataAccessException {
        return jdbcTemplate.queryForObject(WORK_REQUEST_RECRUITMENT_GET_ONE, new WorkRequestRecruitmentMapper(), id);
    }

    @Override
    public boolean delete(int id) throws DataAccessException {
        return jdbcTemplate.update(
                WORK_REQUEST_RECRUITMENT_DELETED_ONE,
                id
        ) > 0;
    }
}
