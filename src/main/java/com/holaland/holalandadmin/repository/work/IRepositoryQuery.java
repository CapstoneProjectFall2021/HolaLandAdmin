package com.holaland.holalandadmin.repository.work;

public interface IRepositoryQuery {

    String STT_WORK_GET_ONE_BY_CODE = "SELECT * FROM stt_work WHERE stt_work_code = ? AND stt_work_name = 'WORK_REQUEST_RECRUITMENT_FIND_JOB'";

    String WORK_PAYMENT_METHOD_GET_ONE = "SELECT * FROM work_payment_method WHERE work_payment_method_id = ? " +
            "AND work_payment_method_deleted = 0";

    String WORK_REQUEST_FIND_JOB_GET_ALL = "SELECT * FROM work_request_find_job WHERE stt_work_code in (1,2,3,4,5) " +
            "AND work_request_find_job_deleted = 0";
    String WORK_REQUEST_FIND_JOB_GET_ONE = "SELECT * FROM work_request_find_job WHERE work_request_find_job_id = ? " +
            "AND work_request_find_job_deleted = 0";
    String WORK_REQUEST_FIND_JOB_APPROVE = "UPDATE work_request_find_job\n" +
            "SET stt_work_code = 3\n" +
            "WHERE work_request_find_job_id = ?";
    String WORK_REQUEST_FIND_JOB_DELETED_ONE = "UPDATE work_request_find_job\n" +
            "SET work_request_find_job_deleted = 1\n" +
            "WHERE work_request_find_job_id = ?";

    String WORK_REQUEST_RECRUITMENT_GET_ALL = "SELECT * FROM work_request_recruitment WHERE stt_work_code in (1,2,3,4,5) " +
            "AND work_request_recruitment_deleted = 0";
    String WORK_REQUEST_RECRUITMENT_GET_ONE = "SELECT * FROM work_request_recruitment WHERE work_request_recruitment_id = ? " +
            "AND work_request_recruitment_deleted = 0";
    String WORK_REQUEST_RECRUITMENT_APPROVE = "UPDATE work_request_recruitment\n" +
            "SET stt_work_code = 3\n" +
            "WHERE work_request_recruitment_id = ?";
    String WORK_REQUEST_RECRUITMENT_DELETED_ONE = "UPDATE work_request_recruitment\n" +
            "SET work_request_recruitment_deleted = 1\n" +
            "WHERE work_request_recruitment_id = ?";

    String WORK_REQUEST_TYPE_GET_ONE = "SELECT * FROM work_request_type WHERE work_request_type_id = ? AND work_request_type_deleted = 0";

    String WORK_SALARY_UNIT_GET_ONE = "SELECT * FROM work_salary_unit WHERE work_salary_unit_id = ?";

    String WORK_TIME_GET_ONE = "SELECT * FROM work_time WHERE work_time_id = ? AND work_time_deleted = 0";

    String CANCEL_FIND_JOB = "UPDATE work_request_find_job\n" +
            "SET stt_work_code = 2,\n" +
            "    work_request_find_job_note = ?\n" +
            "WHERE work_request_find_job_id =?";

    String CANCEL_RECRUITMENT = "UPDATE work_request_recruitment\n" +
            "SET stt_work_code = 2,\n" +
            "    work_request_recruitment_note = ?\n" +
            "WHERE work_request_recruitment_id = ?";
}
