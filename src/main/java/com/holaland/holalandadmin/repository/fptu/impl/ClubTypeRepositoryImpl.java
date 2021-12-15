package com.holaland.holalandadmin.repository.fptu.impl;

import com.holaland.holalandadmin.entity.fptu.ClubType;
import com.holaland.holalandadmin.mapper.fptu.ClubTypeMapper;
import com.holaland.holalandadmin.repository.fptu.ClubTypeRepository;
import com.holaland.holalandadmin.repository.fptu.IRepositoryQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClubTypeRepositoryImpl implements ClubTypeRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClubTypeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ClubType getOne(int id) throws DataAccessException {
        return jdbcTemplate.queryForObject(CLUB_TYPE_GET_ONE, new ClubTypeMapper(), id);
    }
}
