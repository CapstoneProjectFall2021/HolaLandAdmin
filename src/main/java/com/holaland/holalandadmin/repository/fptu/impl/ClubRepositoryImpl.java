package com.holaland.holalandadmin.repository.fptu.impl;

import com.holaland.holalandadmin.entity.fptu.Club;
import com.holaland.holalandadmin.mapper.fptu.ClubMapper;
import com.holaland.holalandadmin.repository.fptu.ClubRepository;
import com.holaland.holalandadmin.repository.fptu.IRepositoryQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClubRepositoryImpl implements ClubRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClubRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Club> getAll() throws DataAccessException {
        return jdbcTemplate.query(FPTU_CLUB_GET_ALL, new ClubMapper());
    }
}
