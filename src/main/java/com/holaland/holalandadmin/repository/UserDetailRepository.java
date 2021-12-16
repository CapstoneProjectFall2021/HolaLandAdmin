package com.holaland.holalandadmin.repository;

import com.holaland.holalandadmin.entity.UserDetail;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface UserDetailRepository {

    List<UserDetail> getAllUserBookedByUserId(int id) throws DataAccessException;

    List<UserDetail> getAllUserAppliedByUserId(int id) throws DataAccessException;

    List<UserDetail> getAllUserInfo(Integer... status) throws DataAccessException;

    UserDetail getOneByUserId(int id) throws DataAccessException;

    boolean update(UserDetail obj) throws DataAccessException;
}
