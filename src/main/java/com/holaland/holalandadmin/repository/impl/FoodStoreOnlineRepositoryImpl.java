package com.holaland.holalandadmin.repository.impl;

import com.holaland.holalandadmin.entity.food.FoodStoreOnline;
import com.holaland.holalandadmin.mapper.food.FoodStoreOnlineMapper;
import com.holaland.holalandadmin.repository.food.FoodStoreOnlineRepository;
import com.holaland.holalandadmin.repository.IRepositoryQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodStoreOnlineRepositoryImpl implements FoodStoreOnlineRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FoodStoreOnlineRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<FoodStoreOnline> getAll() throws DataAccessException {
        return jdbcTemplate.query(FOOD_STORE_ONLINE_GET_ALL,new FoodStoreOnlineMapper());
    }

    @Override
    public FoodStoreOnline getOne(int id) throws DataAccessException {
        return jdbcTemplate.queryForObject(FOOD_STORE_ONLINE_GET_ONE,new FoodStoreOnlineMapper(),id);
    }

    @Override
    public boolean lock(int id) throws DataAccessException {
        return jdbcTemplate.update(FOOD_STORE_ONLINE_LOCK_ONE, id) > 0;
    }

    @Override
    public boolean unlock(int id) throws DataAccessException {
        return jdbcTemplate.update(FOOD_STORE_ONLINE_UNLOCK_ONE, id) > 0;
    }

}
