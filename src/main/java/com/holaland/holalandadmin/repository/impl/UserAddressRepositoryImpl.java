package com.holaland.holalandadmin.repository.impl;

import com.holaland.holalandadmin.entity.UserAddress;
import com.holaland.holalandadmin.mapper.UserAddressMapper;
import com.holaland.holalandadmin.repository.IRepositoryQuery;
import com.holaland.holalandadmin.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserAddressRepositoryImpl implements UserAddressRepository, IRepositoryQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserAddressRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserAddress> getAllAddressByUserId(int id) throws DataAccessException {
        return jdbcTemplate.query(GET_USER_ADDRESS_BY_USER_ID, new UserAddressMapper(), id);
    }

    @Override
    public UserAddress getOneByUserId(int id) throws DataAccessException {
        return jdbcTemplate.queryForObject(GET_ONE_ADDRESS_BY_USER_ID, new UserAddressMapper(), id);
    }

    @Override
    public boolean save(UserAddress obj) throws DataAccessException {
        return jdbcTemplate.update(
                INSERT_USER_ADDRESS_ONE,
                obj.getUserId(),
                obj.getUserName(),
                obj.getUserPhone(),
                obj.getUserAddress(),
                obj.getUserAddressDefault(),
                obj.getUserAddressDeleted()
        ) > 0;
    }

    @Override
    public boolean update(UserAddress obj) throws DataAccessException {
        return jdbcTemplate.update(
                UPDATE_USER_ADDRESS_ONE,
                obj.getUserName(),
                obj.getUserPhone(),
                obj.getUserAddress(),
                obj.getUserAddressId()
        ) > 0;
    }

    @Override
    public boolean updateDefaultAddress(int id) throws DataAccessException {
        return jdbcTemplate.update(
                UPDATE_USER_ADDRESS_DEFAULT,
                id
        ) > 0;
    }

    @Override
    public boolean delete(int id) throws DataAccessException {
        return jdbcTemplate.update(
                DELETE_USER_ADDRESS_ONE,
                id
        ) > 0;
    }

    @Override
    public boolean deleteDefaultAddressByUserId(int userId) throws DataAccessException {
        return jdbcTemplate.update(
                DELETE_USER_ADDRESS_DEFAULT_BY_USER_ID,
                userId
        ) > 0;
    }
}
