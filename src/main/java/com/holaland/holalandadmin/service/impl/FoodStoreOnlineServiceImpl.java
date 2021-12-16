package com.holaland.holalandadmin.service.impl;

import com.holaland.holalandadmin.entity.food.FoodStoreOnline;
import com.holaland.holalandadmin.repository.FoodStoreOnlineRepository;
import com.holaland.holalandadmin.service.FoodStoreOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodStoreOnlineServiceImpl implements FoodStoreOnlineService {

    private final FoodStoreOnlineRepository foodStoreOnlineRepository;

    @Autowired
    public FoodStoreOnlineServiceImpl(FoodStoreOnlineRepository foodStoreOnlineRepository) {
        this.foodStoreOnlineRepository = foodStoreOnlineRepository;
    }

    @Override
    public List<FoodStoreOnline> getAll() throws DataAccessException {
        return foodStoreOnlineRepository.getAll();
    }

    @Override
    public FoodStoreOnline getOne(int id) throws DataAccessException {
        return foodStoreOnlineRepository.getOne(id);
    }

    @Override
    public boolean delete(int id) throws DataAccessException {
        return foodStoreOnlineRepository.delete(id);
    }

}
