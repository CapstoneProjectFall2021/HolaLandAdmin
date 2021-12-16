package com.holaland.holalandadmin.repository.impl;


import com.holaland.holalandadmin.entity.User;
import com.holaland.holalandadmin.mapper.UserMapper;
import com.holaland.holalandadmin.repository.IRepositoryQuery;
import com.holaland.holalandadmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findByEmail(String email) {
        return jdbcTemplate.queryForObject(GET_USER_BY_USER_EMAIL, new UserMapper(), email);
    }

    @Override
    public boolean delete(int id) throws DataAccessException {
        return jdbcTemplate.update(USER_DELETE_ONE, id) > 0;
    }
}
