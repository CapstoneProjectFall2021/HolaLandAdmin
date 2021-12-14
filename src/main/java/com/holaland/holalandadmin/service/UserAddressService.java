package com.holaland.holalandadmin.service;

import com.holaland.holalandadmin.entity.UserAddress;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface UserAddressService {

    List<UserAddress> getAllAddressByUserId(int id) throws DataAccessException;

    UserAddress getOneByUserId(int id) throws DataAccessException;

    boolean save(UserAddress obj) throws DataAccessException;

    boolean update(UserAddress obj) throws DataAccessException;

    boolean updateDefaultAddress(int id, int userId) throws DataAccessException;

    boolean delete(int id) throws DataAccessException;

    boolean deleteDefaultAddressByUserId(int userId) throws DataAccessException;
}
