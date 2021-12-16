package com.holaland.holalandadmin.service;

import com.holaland.holalandadmin.entity.food.FoodStoreOnline;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface FoodStoreOnlineService {

    List<FoodStoreOnline> getAll() throws DataAccessException;

    FoodStoreOnline getOne(int id) throws DataAccessException;

    boolean delete(int id) throws DataAccessException;

}
