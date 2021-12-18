package com.holaland.holalandadmin.repository;

import com.holaland.holalandadmin.entity.Role;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface RoleRepository {

    List<Role> getRolesByUserEmail(String email);

    List<Role> getRoleByUserId(int id) throws DataAccessException;
}
