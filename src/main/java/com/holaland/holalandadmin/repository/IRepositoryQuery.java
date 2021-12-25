package com.holaland.holalandadmin.repository;

public interface IRepositoryQuery {

    String GET_USER_BY_USER_EMAIL = "SELECT * FROM user WHERE user_email = ? AND user_status_id = 1 AND user_deleted = 0";

    String GET_ROLES_BY_USER_EMAIL = "SELECT T3.role_id, T3.role_name\n" +
            "FROM user T1\n" +
            "LEFT OUTER JOIN user_role T2\n" +
            "ON T1.user_id = T2.user_id\n" +
            "LEFT OUTER JOIN role T3\n" +
            "ON T3.role_id = T2.role_id\n" +
            "WHERE T1.user_email = ?\n" +
            "AND T1.user_status_id = 1\n" +
            "AND T1.user_deleted = 0";

    String USER_DETAIL_GET_ALL = "SELECT * FROM user_detail";
    String USER_DETAIL_GET_ONE_BY_USER_ID = "SELECT * FROM user_detail WHERE user_id = ?";

    String GET_LIST_USER_BOOKED_BY_USER_ID = "SELECT\n" +
            "T2.user_detail_id,\n" +
            "T2.user_id,\n" +
            "T2.user_name,\n" +
            "T2.user_dob,\n" +
            "T2.user_phone,\n" +
            "T2.user_gender,\n" +
            "T2.user_email\n" +
            "FROM work_request_book T1\n" +
            "INNER JOIN user_detail T2\n" +
            "ON T1.user_id = T2.user_id\n" +
            "WHERE T1.work_request_find_job_id = ?";

    String GET_LIST_USER_APPLIED_BY_USER_ID = "SELECT\n" +
            "T2.user_detail_id,\n" +
            "T2.user_id,\n" +
            "T2.user_name,\n" +
            "T2.user_dob,\n" +
            "T2.user_phone,\n" +
            "T2.user_gender,\n" +
            "T2.user_email\n" +
            "FROM work_request_apply T1\n" +
            "INNER JOIN user_detail T2\n" +
            "ON T1.user_id = T2.user_id\n" +
            "WHERE T1.work_request_recruitment_id = ?";

    String GET_USER_DETAIL_BY_USER_ID = "SELECT * FROM user_detail WHERE user_id = ?";

    String GET_USER_ADDRESS_BY_USER_ID = "SELECT * FROM user_address WHERE user_id = ? " +
            "AND user_address_deleted = 0";

    String GET_ONE_ADDRESS_BY_USER_ID = "SELECT *\n" +
            "FROM user_address\n" +
            "WHERE user_id = ?\n" +
            "AND user_address_deleted = 0\n" +
            "AND user_address_default = 1";

    String INSERT_USER_ADDRESS_ONE = "INSERT INTO user_address(user_id, user_name, user_phone, user_address, " +
            "user_address_default, user_address_deleted) VALUES (?, ?, ?, ?, ?, ?)";

    String UPDATE_USER_ADDRESS_ONE = "UPDATE user_address\n" +
            "SET user_name = ?, user_phone = ?, user_address = ?\n" +
            "WHERE user_address_id = ?";

    String UPDATE_USER_ADDRESS_DEFAULT = "UPDATE user_address\n" +
            "SET user_address_default = 1\n" +
            "WHERE user_address_id = ?";

    String DELETE_USER_ADDRESS_ONE = "UPDATE user_address\n" +
            "SET user_address_deleted = 1\n" +
            "WHERE user_address_id = ?";

    String DELETE_USER_ADDRESS_DEFAULT_BY_USER_ID = "UPDATE user_address\n" +
            "SET user_address_default = 0\n" +
            "WHERE user_id = ?";

    String USER_DETAIL_UPDATE_ONE = "UPDATE user_detail\n" +
            "SET user_name = ?, user_dob = ?,  user_gender = ?, user_phone = ?, user_email = ?\n" +
            "WHERE user_id = ?";

    String USER_DELETE_ONE = "UPDATE user\n" +
            "SET user_deleted = 1\n" +
            "WHERE user_id = ?";

    String USER_GET_ONE = "SELECT * FROM user WHERE user_id = ? AND user_deleted = 0";

    String USER_UNLOCK = "UPDATE user\n" +
            "SET user_status_id = 1\n" +
            "WHERE user_id = ?;";

    String USER_LOCK = "UPDATE user\n" +
            "SET user_status_id = 2\n" +
            "WHERE user_id = ?;";

    String USER_GET_ROLE = "SELECT * FROM user_role WHERE user_id = ?";

    String GET_ROLE_BY_USER_ID = "SELECT T3.role_id, T3.role_name\n" +
            "FROM user T1\n" +
            "LEFT OUTER JOIN user_role T2\n" +
            "    ON T1.user_id = T2.user_id\n" +
            "LEFT OUTER JOIN role T3\n" +
            "    ON T3.role_id = T2.role_id\n" +
            "WHERE T1.user_id = ?\n" +
            "AND T1.user_deleted = 0";

    String FOOD_STORE_ONLINE_GET_ALL = "SELECT * FROM food_store_online";
    String FOOD_STORE_ONLINE_GET_ONE = "SELECT * FROM food_store_online WHERE food_store_online_id = ?";

    String FOOD_STORE_ONLINE_LOCK_ONE = "UPDATE food_store_online\n" +
            "SET food_store_online_deleted = 1\n" +
            "WHERE food_store_online_id = ?";

    String FOOD_STORE_ONLINE_UNLOCK_ONE = "UPDATE food_store_online\n" +
            "SET food_store_online_deleted = 0\n" +
            "WHERE food_store_online_id = ?";

    String FOOD_STORE_ONLINE_RATE_GET_ALL_BY_STORE_ONLINE_ID = "SELECT * FROM food_store_online_rate WHERE food_store_online_id = ?";

    String FOOD_REPORT_GET_ALL_BY_STORE_ONLINE_ID = "SELECT * FROM food_report WHERE food_store_online_id = ?";

    String COUNT_ALL_DASHBOARD = "SELECT count_userAcc, count_studentAcc, count_recruitmentAcc, count_sellerAcc,\n" +
            "                   count_post_recruitment, count_post_find_job,\n" +
            "                   count_store, count_order, total_price,\n" +
            "                   sum_sold_items\n" +
            "            FROM\n" +
            "                 (SELECT COUNT(user_id) count_userAcc\n" +
            "                     FROM user\n" +
            "                     WHERE user_deleted = 0) A0,\n" +
            "                (SELECT T1.count_studentAcc, T2.count_recruitmentAcc, T3.count_sellerAcc\n" +
            "                    FROM\n" +
            "                        (SELECT COUNT(role_id) count_studentAcc, user_id\n" +
            "                            FROM user_role\n" +
            "                            WHERE role_id = 4) T1,\n" +
            "                        (SELECT COUNT(role_id) count_recruitmentAcc, user_id\n" +
            "                            FROM user_role\n" +
            "                            WHERE role_id = 2) T2,\n" +
            "                        (SELECT COUNT(role_id) count_sellerAcc, user_id\n" +
            "                            FROM user_role\n" +
            "                            WHERE role_id = 3) T3\n" +
            "                        ) A1,\n" +
            "                (SELECT T1.count_post_recruitment, T2.count_post_find_job\n" +
            "                    FROM\n" +
            "                        (SELECT COUNT(work_request_recruitment_id) count_post_recruitment, stt_work_code\n" +
            "                            FROM work_request_recruitment\n" +
            "                            WHERE stt_work_code in(3,4,5)) T1\n" +
            "                        LEFT OUTER JOIN (SELECT COUNT(work_request_find_job_id) count_post_find_job, stt_work_code\n" +
            "                            FROM work_request_find_job\n" +
            "                            WHERE stt_work_code in(3,4,5)) T2\n" +
            "                        ON T1.stt_work_code != T2.stt_work_code OR T1.stt_work_code = T2.stt_work_code) A2,\n" +
            "                (SELECT T1.count_order, T2.total_price\n" +
            "                    FROM\n" +
            "                        (SELECT COUNT(food_order_id) count_order, stt_food_code\n" +
            "                            FROM food_order\n" +
            "                            WHERE stt_food_code = 4) T1\n" +
            "                        LEFT OUTER JOIN (SELECT SUM(food_order_total_price) total_price, stt_food_code\n" +
            "                            FROM food_order\n" +
            "                            WHERE stt_food_code = 4) T2\n" +
            "                        ON T1.stt_food_code = T2.stt_food_code) A3,\n" +
            "                (SELECT SUM(T1.food_item_quantity) sum_sold_items\n" +
            "                    FROM food_order_detail T1\n" +
            "                    LEFT OUTER JOIN food_order T2\n" +
            "                    ON T1.food_order_id = T2.food_order_id\n" +
            "                    WHERE T2.stt_food_code = 4) A4,\n" +
            "                 (SELECT COUNT(food_store_online_id) count_store\n" +
            "                     FROM food_store_online) A5";
}
