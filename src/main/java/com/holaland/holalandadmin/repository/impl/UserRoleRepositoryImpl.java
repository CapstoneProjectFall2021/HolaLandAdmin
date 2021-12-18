package com.holaland.holalandadmin.repository.impl;

import com.holaland.holalandadmin.entity.UserRole;
import com.holaland.holalandadmin.mapper.UserRoleMapper;
import com.holaland.holalandadmin.repository.IRepositoryQuery;
import com.holaland.holalandadmin.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRoleRepositoryImpl implements UserRoleRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRoleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserRole> getRole(int id) throws DataAccessException {
        return jdbcTemplate.query(USER_GET_ROLE, new UserRoleMapper(), id);
    }
}
