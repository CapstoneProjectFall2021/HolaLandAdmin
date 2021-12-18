package com.holaland.holalandadmin.repository;

import com.holaland.holalandadmin.entity.UserRole;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface UserRoleRepository {

    List<UserRole> getRole(int id) throws DataAccessException;

}
