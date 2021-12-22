package com.holaland.holalandadmin.service.traffic.impl;

import com.holaland.holalandadmin.entity.traffic.Bus;
import com.holaland.holalandadmin.repository.traffic.BusRepository;
import com.holaland.holalandadmin.service.traffic.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;

    @Autowired
    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public List<Bus> getAll() throws DataAccessException {
        return busRepository.getAll();
    }

    @Override
    public Bus getOne(int id) throws DataAccessException {
        return busRepository.getOne(id);
    }

    @Override
    public boolean delete(int id) throws DataAccessException {
        return busRepository.delete(id);
    }

    @Override
    public boolean update(Bus obj) throws DataAccessException {
        return busRepository.update(obj);
    }

    @Override
    public boolean add(Bus obj) throws DataAccessException {
        return busRepository.add(obj);
    }
}
