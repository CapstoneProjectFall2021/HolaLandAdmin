package com.holaland.holalandadmin.repository.impl;

import com.holaland.holalandadmin.entity.Role;
import com.holaland.holalandadmin.mapper.RoleMapper;
import com.holaland.holalandadmin.repository.IRepositoryQuery;
import com.holaland.holalandadmin.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> getRolesByUserEmail(String email) {
        return jdbcTemplate.query(GET_ROLES_BY_USER_EMAIL, new RoleMapper(), email);
    }

    @Override
    public List<Role> getRoleByUserId(int id) throws DataAccessException {
        return jdbcTemplate.query(GET_ROLE_BY_USER_ID, new RoleMapper(), id);
    }
}
