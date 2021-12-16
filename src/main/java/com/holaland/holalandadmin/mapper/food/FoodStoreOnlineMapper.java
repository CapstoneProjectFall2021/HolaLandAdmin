package com.holaland.holalandadmin.mapper.food;

import com.holaland.holalandadmin.entity.food.FoodStoreOnline;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodStoreOnlineMapper implements RowMapper<FoodStoreOnline> {
    @Override
    public FoodStoreOnline mapRow(ResultSet rs, int rowNum) throws SQLException {
        return FoodStoreOnline.builder()
                .foodStoreOnlineId(rs.getInt("food_store_online_id"))
                .userId(rs.getInt("user_id"))
                .sttFoodCode(rs.getInt("stt_food_code"))
                .foodStoreOnlineImage(rs.getString("food_store_online_image"))
                .foodStoreOnlineName(rs.getString("food_store_online_name"))
                .foodStoreOnlineRate(rs.getDouble("food_store_online_rate"))
                .foodStoreOnlineMinPrice(rs.getInt("food_store_online_min_price"))
                .foodStoreOnlineMaxPrice(rs.getInt("food_store_online_max_price"))
                .foodStoreOnlineDescription(rs.getString("food_store_online_description"))
                .foodStoreOnlineCountFoodItem(rs.getInt("food_store_online_count_food_item"))
                .foodStoreOnlineCountRate(rs.getInt("food_store_online_count_rate"))
                .foodStoreOnlineCountReport(rs.getInt("food_store_online_count_report"))
                .foodStoreOnlinePauseSellingFlag(rs.getBoolean("food_store_online_pause_selling_flag"))
                .foodStoreOnlineStopSellingFlag(rs.getBoolean("food_store_online_stop_selling_flag"))
                .foodStoreOnlineDeleted(rs.getBoolean("food_store_online_deleted"))
                .build();
    }
}
