package com.holaland.holalandadmin.repository.work;

public interface IRepositoryQuery {

    String STT_WORK_GET_ONE_BY_CODE = "SELECT * FROM stt_work WHERE stt_work_code = ? AND stt_work_name = 'WORK_REQUEST_RECRUITMENT_FIND_JOB'";

    String WORK_PAYMENT_METHOD_GET_ONE = "SELECT * FROM work_payment_method WHERE work_payment_method_id = ? " +
            "AND work_payment_method_deleted = 0";

    String WORK_REQUEST_FIND_JOB_GET_ALL = "SELECT * FROM work_request_find_job WHERE work_request_find_job_deleted = 0";

    String WORK_REQUEST_RECRUITMENT_GET_ALL = "SELECT * FROM work_request_recruitment WHERE work_request_recruitment_deleted = 0";

    String WORK_REQUEST_TYPE_GET_ONE = "SELECT * FROM work_request_type WHERE work_request_type_id = ? AND work_request_type_deleted = 0";

    String WORK_SALARY_UNIT_GET_ONE = "SELECT * FROM work_salary_unit WHERE work_salary_unit_id = ?";

    String WORK_TIME_GET_ONE = "SELECT * FROM work_time WHERE work_time_id = ? AND work_time_deleted = 0";
}
