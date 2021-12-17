package com.holaland.holalandadmin.mapper.food;

import com.holaland.holalandadmin.entity.food.FoodStoreOnlineRate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodStoreOnlineRateMapper implements RowMapper<FoodStoreOnlineRate> {
    @Override
    public FoodStoreOnlineRate mapRow(ResultSet rs, int rowNum) throws SQLException {
        return FoodStoreOnlineRate.builder()
                .foodStoreOnlineRateId(rs.getInt("food_store_online_rate_id"))
                .userId(rs.getInt("user_id"))
                .foodStoreOnlineId(rs.getInt("food_store_online_id"))
                .foodStoreOnlineRatePoint(rs.getInt("food_store_online_rate_point"))
                .foodStoreOnlineRateComment(rs.getString("food_store_online_rate_comment"))
                .foodStoreOnlineRateCreateTime(rs.getTimestamp("food_store_online_rate_create_time"))
                .foodStoreOnlineRateUpdateTime(rs.getTimestamp("food_store_online_rate_update_time"))
                .foodStoreOnlineDeleted(rs.getBoolean("food_store_online_rate_deleted"))
                .build();
    }
}
