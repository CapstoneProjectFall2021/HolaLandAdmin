package com.holaland.holalandadmin.mapper;

import com.holaland.holalandadmin.entity.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleMapper implements RowMapper<UserRole> {

    @Override
    public UserRole mapRow(ResultSet resultSet, int i) throws SQLException {
        return UserRole.builder()
                .userRoleId(resultSet.getInt("user_role_id"))
                .userId(resultSet.getInt("user_id"))
                .roleId(resultSet.getInt("role_id"))
                .build();
    }
}
