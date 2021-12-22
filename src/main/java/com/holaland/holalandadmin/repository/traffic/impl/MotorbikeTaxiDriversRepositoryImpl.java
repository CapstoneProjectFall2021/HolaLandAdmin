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
    public MotorbikeTaxiDrivers getOne(int id) throws DataAccessException {
        return jdbcTemplate.queryForObject(GET_ONE_DRIVER, new MotorbikeTaxiDriversMapper(), id);
    }

    @Override
    public boolean delete(int id) throws DataAccessException {
        return jdbcTemplate.update(
                MOTORBIKE_TAXI_DRIVERS_DELETE_ONE,
                id
        ) > 0;
    }

    @Override
    public boolean update(MotorbikeTaxiDrivers obj) throws DataAccessException {
        return jdbcTemplate.update(
                UPDATE_DRIVER,
                obj.getTfMotorbikeTaxiDriversName(),
                obj.getTfMotorbikeTaxiDriversStartTime(),
                obj.getTfMotorbikeTaxiDriversEndTime(),
                obj.isTfMotorbikeTaxiDriversGender(),
                obj.getTfMotorbikeTaxiDriversPhone(),
                obj.getTfMotorbikeTaxiDriversLicensePlates(),
                obj.getTfMotorbikeTaxiDriversVehicleType(),
                obj.getTfMotorbikeTaxiDriversId()
        ) > 0;
    }

    @Override
    public Boolean add(MotorbikeTaxiDrivers obj) throws DataAccessException {
        return jdbcTemplate.update(
                ADD_NEW_DRIVER,
                obj.getTfMotorbikeTaxiDriversName(), obj.isTfMotorbikeTaxiDriversGender(),
                obj.getTfMotorbikeTaxiDriversPhone(), obj.getTfMotorbikeTaxiDriversLicensePlates(),
                obj.getTfMotorbikeTaxiDriversVehicleType(), obj.getTfMotorbikeTaxiDriversStartTime(),
                obj.getTfMotorbikeTaxiDriversEndTime()
        ) > 0;
    }
}
