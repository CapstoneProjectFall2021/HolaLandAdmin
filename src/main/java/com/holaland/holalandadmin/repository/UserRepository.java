package com.holaland.holalandadmin.repository;

import com.holaland.holalandadmin.entity.User;
import org.springframework.dao.DataAccessException;

public interface UserRepository {

    User findByEmail(String email);

    boolean delete(int id) throws DataAccessException;
}
