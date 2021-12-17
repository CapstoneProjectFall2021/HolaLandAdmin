package com.holaland.holalandadmin.repository;

import com.holaland.holalandadmin.entity.UserRole;
import org.springframework.dao.DataAccessException;

public interface UserRoleRepository {

    UserRole getRole(int id) throws DataAccessException;

}
