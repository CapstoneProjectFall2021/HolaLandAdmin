package com.holaland.holalandadmin.service;

import org.springframework.dao.DataAccessException;

public interface UserService {

    boolean delete(int id) throws DataAccessException;

}
