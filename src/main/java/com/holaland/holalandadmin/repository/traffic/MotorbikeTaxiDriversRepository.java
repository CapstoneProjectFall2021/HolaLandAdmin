package com.holaland.holalandadmin.repository.traffic;

import com.holaland.holalandadmin.entity.traffic.MotorbikeTaxiDrivers;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface MotorbikeTaxiDriversRepository {

    List<MotorbikeTaxiDrivers> getAll() throws DataAccessException;

    MotorbikeTaxiDrivers getOne(int id) throws DataAccessException;

    boolean delete(int id) throws DataAccessException;

    boolean update(MotorbikeTaxiDrivers obj) throws DataAccessException;

    Boolean add(MotorbikeTaxiDrivers obj) throws DataAccessException;
}
