package com.holaland.holalandadmin.service;

import com.holaland.holalandadmin.entity.Role;
import com.holaland.holalandadmin.entity.UserRole;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface UserRoleService {

    List<UserRole> getRole(int id) throws DataAccessException;

    List<Role> getRoleByUserId(int id) throws DataAccessException;

}
