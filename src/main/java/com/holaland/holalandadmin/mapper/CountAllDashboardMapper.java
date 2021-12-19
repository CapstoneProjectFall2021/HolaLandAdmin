package com.holaland.holalandadmin.mapper;

import com.holaland.holalandadmin.view.CountAllDashboard;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountAllDashboardMapper implements RowMapper<CountAllDashboard> {
    @Override
    public CountAllDashboard mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CountAllDashboard.builder()
                .countUserAcc(rs.getInt("count_userAcc"))
                .countStudentAcc(rs.getInt("count_studentAcc"))
                .countRecruitmentAcc(rs.getInt("count_recruitmentAcc"))
                .countSellerAcc(rs.getInt("count_sellerAcc"))
                .countPostRecruitment(rs.getInt("count_post_recruitment"))
                .countPostFindJob(rs.getInt("count_post_find_job"))
                .countStore(rs.getInt("count_store"))
                .countOrder(rs.getInt("count_order"))
                .totalPrice(rs.getInt("total_price"))
                .sumSoldItems(rs.getInt("sum_sold_items"))
                .build();
    }
}
