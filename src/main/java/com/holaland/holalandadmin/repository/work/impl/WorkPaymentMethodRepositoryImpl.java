package com.holaland.holalandadmin.repository.work.impl;

import com.holaland.holalandadmin.entity.work.WorkPaymentMethod;
import com.holaland.holalandadmin.mapper.work.WorkPaymentMethodMapper;
import com.holaland.holalandadmin.repository.work.IRepositoryQuery;
import com.holaland.holalandadmin.repository.work.WorkPaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WorkPaymentMethodRepositoryImpl implements WorkPaymentMethodRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkPaymentMethodRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public WorkPaymentMethod getOne(int id) throws DataAccessException {
        return jdbcTemplate.queryForObject(WORK_PAYMENT_METHOD_GET_ONE, new WorkPaymentMethodMapper(), id);
    }
}
