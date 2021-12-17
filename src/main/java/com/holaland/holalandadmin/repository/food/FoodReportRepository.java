package com.holaland.holalandadmin.repository.food;

import com.holaland.holalandadmin.entity.food.FoodReport;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface FoodReportRepository {


    List<FoodReport> getAllByStoreOnlineId(int id) throws DataAccessException;

}
