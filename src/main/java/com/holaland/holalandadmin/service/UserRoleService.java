package com.holaland.holalandadmin.service;

import com.holaland.holalandadmin.entity.UserRole;
import org.springframework.dao.DataAccessException;

public interface UserRoleService {

    UserRole getRole(int id) throws DataAccessException;

}
