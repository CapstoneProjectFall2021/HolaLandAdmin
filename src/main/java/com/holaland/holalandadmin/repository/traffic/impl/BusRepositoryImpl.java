package com.holaland.holalandadmin.repository.traffic.impl;

import com.holaland.holalandadmin.entity.traffic.Bus;
import com.holaland.holalandadmin.mapper.traffic.BusMapper;
import com.holaland.holalandadmin.repository.traffic.BusRepository;
import com.holaland.holalandadmin.repository.traffic.IRepositoryQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BusRepositoryImpl implements BusRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BusRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Bus> getAll() throws DataAccessException {
        return jdbcTemplate.query(BUS_GET_ALL, new BusMapper());
    }

    @Override
    public Bus getOne(int id) throws DataAccessException {
        return jdbcTemplate.queryForObject(BUS_GET_ONE, new BusMapper(), id);
    }

    @Override
    public boolean delete(int id) throws DataAccessException {
        return jdbcTemplate.update(
                BUS_DELETE_ONE,
                id
        ) > 0;
    }

    @Override
    public boolean update(Bus obj) throws DataAccessException {
        return jdbcTemplate.update(
                UPDATE_BUS,
                obj.getTfBusName(), obj.getTfBusStartTime(),
                obj.getTfBusEndTime(), obj.getTfBusPrice(),
                obj.getTfBusInfo(),
                obj.getTfBusId()
        ) > 0;
    }

    @Override
    public boolean add(Bus obj) throws DataAccessException {
        return jdbcTemplate.update(
                ADD_NEW_BUS,
                obj.getTfBusName(), obj.getTfBusStartTime(),
                obj.getTfBusEndTime(), obj.getTfBusInfo(),
                obj.getTfBusPrice()
        ) > 0;
    }
}
