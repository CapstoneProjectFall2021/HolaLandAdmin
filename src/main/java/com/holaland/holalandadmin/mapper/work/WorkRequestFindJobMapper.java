package com.holaland.holalandadmin.mapper.work;

import com.holaland.holalandadmin.entity.work.WorkRequestFindJob;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkRequestFindJobMapper implements RowMapper<WorkRequestFindJob> {

    @Override
    public WorkRequestFindJob mapRow(ResultSet resultSet, int i) throws SQLException {
        return WorkRequestFindJob.builder()
                .workRequestFindJobId(resultSet.getInt("work_request_find_job_id"))
                .userId(resultSet.getInt("user_id"))
                .workRequestTypeId(resultSet.getInt("work_request_type_id"))
                .workTimeId(resultSet.getInt("work_time_id"))
                .sttWorkCode(resultSet.getInt("stt_work_code"))
                .workPaymentMethodId(resultSet.getInt("work_payment_method_id"))
                .workSalaryUnitId(resultSet.getInt("work_salary_unit_id"))
                .workRequestFindJobTitle(resultSet.getString("work_request_find_job_title"))
                .workRequestFindJobStartDateTime(resultSet.getDate("work_request_find_job_start_date_time"))
                .workRequestFindJobEndDateTime(resultSet.getDate("work_request_find_job_end_date_time"))
                .workRequestFindJobLastUpdateDateTime(resultSet.getDate("work_request_find_job_last_update_date_time"))
                .workRequestFindJobDescription(resultSet.getString("work_request_find_job_description"))
                .workRequestFindJobPersonalExperience(resultSet.getString("work_request_find_job_personal_experience"))
                .workRequestFindJobExpectedLocation(resultSet.getString("work_request_find_job_expected_location"))
                .workRequestFindJobExpectedSalary(resultSet.getInt("work_request_find_job_expected_salary"))
                .workRequestFindJobNote(resultSet.getString("work_request_find_job_note"))
                .workRequestFindJobDeleted(resultSet.getBoolean("work_request_find_job_deleted"))
                .build();
    }
}
