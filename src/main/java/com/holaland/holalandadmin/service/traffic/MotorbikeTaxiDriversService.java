package com.holaland.holalandadmin.service.traffic;

import com.holaland.holalandadmin.entity.traffic.MotorbikeTaxiDrivers;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface MotorbikeTaxiDriversService {

    List<MotorbikeTaxiDrivers> getAll() throws DataAccessException;

    MotorbikeTaxiDrivers getOne(int id) throws DataAccessException;

    boolean delete(int id) throws DataAccessException;

    boolean update(MotorbikeTaxiDrivers obj) throws DataAccessException;

    boolean add(MotorbikeTaxiDrivers obj) throws DataAccessException;
}
