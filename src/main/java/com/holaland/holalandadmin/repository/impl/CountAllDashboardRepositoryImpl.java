package com.holaland.holalandadmin.repository.impl;

import com.holaland.holalandadmin.mapper.CountAllDashboardMapper;
import com.holaland.holalandadmin.repository.CountAllDashboardRepository;
import com.holaland.holalandadmin.repository.IRepositoryQuery;
import com.holaland.holalandadmin.view.CountAllDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CountAllDashboardRepositoryImpl implements CountAllDashboardRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CountAllDashboardRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CountAllDashboard count() throws DataAccessException {
        return jdbcTemplate.queryForObject(COUNT_ALL_DASHBOARD, new CountAllDashboardMapper());
    }
}
