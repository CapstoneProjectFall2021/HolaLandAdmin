package com.holaland.holalandadmin.mapper.work;

import com.holaland.holalandadmin.entity.work.WorkSalaryUnit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkSalaryUnitMapper implements RowMapper<WorkSalaryUnit> {

    @Override
    public WorkSalaryUnit mapRow(ResultSet resultSet, int i) throws SQLException {
        return WorkSalaryUnit.builder()
                .workSalaryUnitId(resultSet.getInt("work_salary_unit_id"))
                .workSalaryUnitName(resultSet.getString("work_salary_unit_name"))
                .build();
    }
}
