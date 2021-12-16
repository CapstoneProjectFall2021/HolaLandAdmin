package com.holaland.holalandadmin.repository.work.impl;

import com.holaland.holalandadmin.entity.work.SttWork;
import com.holaland.holalandadmin.mapper.work.SttWorkMapper;
import com.holaland.holalandadmin.repository.work.IRepositoryQuery;
import com.holaland.holalandadmin.repository.work.SttWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SttWorkRepositoryImpl implements SttWorkRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SttWorkRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public SttWork getOneByCode(int code) throws DataAccessException {
        return jdbcTemplate.queryForObject(STT_WORK_GET_ONE_BY_CODE, new SttWorkMapper(), code);
    }
}
