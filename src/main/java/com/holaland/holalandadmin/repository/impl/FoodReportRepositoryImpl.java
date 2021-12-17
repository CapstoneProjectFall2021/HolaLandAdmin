package com.holaland.holalandadmin.repository.impl;

import com.holaland.holalandadmin.entity.food.FoodReport;
import com.holaland.holalandadmin.mapper.food.FoodReportMapper;
import com.holaland.holalandadmin.repository.IRepositoryQuery;
import com.holaland.holalandadmin.repository.food.FoodReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodReportRepositoryImpl implements FoodReportRepository, IRepositoryQuery {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FoodReportRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<FoodReport> getAllByStoreOnlineId(int id) throws DataAccessException {
        return jdbcTemplate.query(FOOD_REPORT_GET_ALL_BY_STORE_ONLINE_ID, new FoodReportMapper(), id);
    }
}
