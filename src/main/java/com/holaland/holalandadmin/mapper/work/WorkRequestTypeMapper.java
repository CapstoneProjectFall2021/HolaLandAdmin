package com.holaland.holalandadmin.mapper.work;

import com.holaland.holalandadmin.entity.work.WorkRequestType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkRequestTypeMapper implements RowMapper<WorkRequestType> {

    @Override
    public WorkRequestType mapRow(ResultSet resultSet, int i) throws SQLException {
        return WorkRequestType.builder()
                .workRequestTypeId(resultSet.getInt("work_request_type_id"))
                .workRequestTypeIcon(resultSet.getString("work_request_type_icon"))
                .workRequestTypeName(resultSet.getString("work_request_type_name"))
                .workRequestTypeCountRequestRecruitment(resultSet.getInt("work_request_type_count_request_recruitment"))
                .workRequestTypeCountRequestFindJob(resultSet.getInt("work_request_type_count_request_find_job"))
                .workRequestTypeDeleted(resultSet.getBoolean("work_request_type_deleted"))
                .build();
    }
}