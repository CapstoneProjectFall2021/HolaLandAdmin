package com.holaland.holalandadmin.service.impl;

import com.holaland.holalandadmin.entity.food.FoodReport;
import com.holaland.holalandadmin.repository.food.FoodReportRepository;
import com.holaland.holalandadmin.service.food.FoodReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodReportServiceImpl implements FoodReportService {

    private final FoodReportRepository foodReportRepository;
    @Autowired
    public FoodReportServiceImpl(FoodReportRepository foodReportRepository) {
        this.foodReportRepository = foodReportRepository;
    }

    @Override
    public List<FoodReport> getAllByStoreOnlineId(int id) throws DataAccessException {
        return foodReportRepository.getAllByStoreOnlineId(id);
    }
}
