package com.holaland.holalandadmin.service.traffic.impl;

import com.holaland.holalandadmin.entity.traffic.MotorbikeTaxiDrivers;
import com.holaland.holalandadmin.repository.traffic.MotorbikeTaxiDriversRepository;
import com.holaland.holalandadmin.service.traffic.MotorbikeTaxiDriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorbikeTaxiDriversServiceImpl implements MotorbikeTaxiDriversService {

    private final MotorbikeTaxiDriversRepository motorbikeTaxiDriversRepository;

    @Autowired
    public MotorbikeTaxiDriversServiceImpl(MotorbikeTaxiDriversRepository motorbikeTaxiDriversRepository) {
        this.motorbikeTaxiDriversRepository = motorbikeTaxiDriversRepository;
    }

    @Override
    public List<MotorbikeTaxiDrivers> getAll() throws DataAccessException {
        return motorbikeTaxiDriversRepository.getAll();
    }

    @Override
    public MotorbikeTaxiDrivers getOne(int id) throws DataAccessException {
        return motorbikeTaxiDriversRepository.getOne(id);
    }

    @Override
    public boolean delete(int id) throws DataAccessException {
        return motorbikeTaxiDriversRepository.delete(id);
    }

    @Override
    public boolean update(MotorbikeTaxiDrivers obj) throws DataAccessException {
        return motorbikeTaxiDriversRepository.update(obj);
    }

    @Override
    public boolean add(MotorbikeTaxiDrivers obj) throws DataAccessException {
        return motorbikeTaxiDriversRepository.add(obj);
    }
}
