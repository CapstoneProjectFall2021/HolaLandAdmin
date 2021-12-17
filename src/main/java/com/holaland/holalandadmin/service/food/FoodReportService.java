package com.holaland.holalandadmin.service.food;

import com.holaland.holalandadmin.entity.food.FoodReport;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface FoodReportService {

    List<FoodReport> getAllByStoreOnlineId(int id) throws DataAccessException;

}
