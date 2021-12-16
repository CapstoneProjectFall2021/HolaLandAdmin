package com.holaland.holalandadmin.repository.traffic.impl;

import com.holaland.holalandadmin.entity.traffic.MotorbikeTaxiDrivers;
import com.holaland.holalandadmin.mapper.traffic.MotorbikeTaxiDriversMapper;
import com.holaland.holalandadmin.repository.traffic.IRepositoryQuery;
import com.holaland.holalandadmin.repository.traffic.MotorbikeTaxiDriversRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorbikeTaxiDriversRepositoryImpl implements MotorbikeTaxiDriversRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MotorbikeTaxiDriversRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MotorbikeTaxiDrivers> getAll() throws DataAccessException {
        return jdbcTemplate.query(MOTORBIKE_TAXI_DRIVERS_GET_ALL, new MotorbikeTaxiDriversMapper());
    }

    @Override
    public boolean delete(int id) throws DataAccessException {
        return jdbcTemplate.update(
                MOTORBIKE_TAXI_DRIVERS_DELETE_ONE,
                id
        ) > 0;
    }
}
