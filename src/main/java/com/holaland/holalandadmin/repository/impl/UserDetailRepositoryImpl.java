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
    public List<UserDetail> getAllUserInfo(Integer... status) throws DataAccessException {
        StringBuilder s = new StringBuilder("(");
        for (int i = 0; i < status.length; i++) {
            s.append((i != status.length - 1) ? status[i] + "," : status[i] + ")");
        }
        String sql ="SELECT DISTINCT T1.user_detail_id, T1.user_id, T1.user_name, T1.user_dob, T1.user_gender, T1.user_phone, T1.user_email\n" +
                "FROM user_detail T1\n" +
                "LEFT JOIN user_role T2\n" +
                "ON T1.user_id = T2.user_id\n" +
                "LEFT JOIN user T3\n" +
                "ON T1.user_id = T3.user_id\n" +
                "WHERE role_id in "+ s +"\n" +
                "  AND T3.user_deleted = 0;";
        return jdbcTemplate.query(sql, new UserDetailMapper());
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
