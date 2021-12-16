package com.holaland.holalandadmin.mapper.work;

import com.holaland.holalandadmin.entity.work.WorkPaymentMethod;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkPaymentMethodMapper implements RowMapper<WorkPaymentMethod> {

    @Override
    public WorkPaymentMethod mapRow(ResultSet resultSet, int i) throws SQLException {
        return WorkPaymentMethod.builder()
                .workPaymentMethodId(resultSet.getInt("work_payment_method_id"))
                .workPaymentMethodName(resultSet.getString("work_payment_method_name"))
                .workPaymentMethodDeleted(resultSet.getBoolean("work_payment_method_deleted"))
                .build();
    }
}
