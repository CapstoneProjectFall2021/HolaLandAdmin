package com.holaland.holalandadmin.repository.traffic;

import com.holaland.holalandadmin.entity.traffic.Bus;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface BusRepository {

    List<Bus> getAll() throws DataAccessException;

    Bus getOne(int id) throws DataAccessException;

    boolean delete(int id) throws DataAccessException;
}
