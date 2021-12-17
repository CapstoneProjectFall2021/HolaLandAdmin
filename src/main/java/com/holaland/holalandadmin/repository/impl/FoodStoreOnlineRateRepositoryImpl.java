package com.holaland.holalandadmin.repository.impl;

import com.holaland.holalandadmin.entity.food.FoodStoreOnlineRate;
import com.holaland.holalandadmin.mapper.food.FoodStoreOnlineRateMapper;
import com.holaland.holalandadmin.repository.IRepositoryQuery;
import com.holaland.holalandadmin.repository.food.FoodStoreOnlineRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodStoreOnlineRateRepositoryImpl implements FoodStoreOnlineRateRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FoodStoreOnlineRateRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<FoodStoreOnlineRate> getAllCommentByStoreOnlineId(int id) throws DataAccessException {
        return jdbcTemplate.query(FOOD_STORE_ONLINE_RATE_GET_ALL_BY_STORE_ONLINE_ID, new FoodStoreOnlineRateMapper(), id);
    }
}
