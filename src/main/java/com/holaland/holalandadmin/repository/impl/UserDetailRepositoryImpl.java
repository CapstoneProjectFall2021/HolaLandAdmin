package com.holaland.holalandadmin.repository.impl;

import com.holaland.holalandadmin.entity.UserDetail;
import com.holaland.holalandadmin.mapper.UserDetailMapper;
import com.holaland.holalandadmin.repository.IRepositoryQuery;
import com.holaland.holalandadmin.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDetailRepositoryImpl implements UserDetailRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDetailRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserDetail> getAllUserBookedByUserId(int id) throws DataAccessException {
        return jdbcTemplate.query(GET_LIST_USER_BOOKED_BY_USER_ID, new UserDetailMapper(), id);
    }

    @Override
    public List<UserDetail> getAllUserAppliedByUserId(int id) throws DataAccessException {
        return jdbcTemplate.query(GET_LIST_USER_APPLIED_BY_USER_ID, new UserDetailMapper(), id);
    }

    @Override
    public UserDetail getOneByUserId(int id) throws DataAccessException {
        return jdbcTemplate.queryForObject(GET_USER_DETAIL_BY_USER_ID, new UserDetailMapper(), id);
    }

    @Override
    public boolean update(UserDetail obj) throws DataAccessException {
        return jdbcTemplate.update(
                USER_DETAIL_UPDATE_ONE,
                obj.getUserDetailName(),
                obj.getUserDetailDob(),
                obj.getUserDetailGender(),
                obj.getUserDetailPhone(),
                obj.getUserDetailEmail(),
                obj.getUserId()
        ) > 0;
    }
}
