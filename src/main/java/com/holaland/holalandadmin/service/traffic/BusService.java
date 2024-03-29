package com.holaland.holalandadmin.service.traffic;

import com.holaland.holalandadmin.entity.traffic.Bus;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface BusService {

    List<Bus> getAll() throws DataAccessException;

    Bus getOne(int id) throws DataAccessException;

    boolean delete(int id) throws DataAccessException;

    boolean update(Bus obj) throws DataAccessException;

    boolean add(Bus obj) throws DataAccessException;
}
