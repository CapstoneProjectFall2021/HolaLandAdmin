package com.holaland.holalandadmin.service;

import com.holaland.holalandadmin.entity.User;
import com.holaland.holalandadmin.entity.UserRole;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface UserService {

    boolean delete(int id) throws DataAccessException;

    User getOne(int id) throws DataAccessException;

    boolean unlock(int id) throws DataAccessException;

    boolean lock(int id) throws DataAccessException;

}
