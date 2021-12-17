package com.holaland.holalandadmin.repository.food;

import com.holaland.holalandadmin.entity.food.FoodStoreOnlineRate;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface FoodStoreOnlineRateRepository {

    List<FoodStoreOnlineRate> getAllCommentByStoreOnlineId(int id) throws DataAccessException;

}
