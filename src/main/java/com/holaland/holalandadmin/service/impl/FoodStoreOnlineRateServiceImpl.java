package com.holaland.holalandadmin.service.impl;

import com.holaland.holalandadmin.entity.food.FoodStoreOnlineRate;
import com.holaland.holalandadmin.repository.food.FoodStoreOnlineRateRepository;
import com.holaland.holalandadmin.service.food.FoodStoreOnlineRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodStoreOnlineRateServiceImpl implements FoodStoreOnlineRateService {

    private final FoodStoreOnlineRateRepository foodStoreOnlineRateRepository;
    @Autowired
    public FoodStoreOnlineRateServiceImpl(FoodStoreOnlineRateRepository foodStoreOnlineRateRepository) {
        this.foodStoreOnlineRateRepository = foodStoreOnlineRateRepository;
    }

    @Override
    public List<FoodStoreOnlineRate> getAllCommentByStoreOnlineId(int id) throws DataAccessException {
        return foodStoreOnlineRateRepository.getAllCommentByStoreOnlineId(id);
    }
}
