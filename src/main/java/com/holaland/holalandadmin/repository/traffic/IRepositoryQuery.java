package com.holaland.holalandadmin.repository.traffic;

public interface IRepositoryQuery {

    String BUS_GET_ALL = "SELECT * FROM tf_bus WHERE tf_bus_deleted = 0";
    String BUS_GET_ONE = "SELECT * FROM tf_bus WHERE tf_bus_id = ? AND tf_bus_deleted = 0";
    String BUS_DELETE_ONE = "UPDATE tf_bus\n" +
            "SET tf_bus_deleted = 1\n" +
            "WHERE tf_bus_id = ?";

    String MOTORBIKE_TAXI_DRIVERS_GET_ALL = "SELECT * FROM tf_motorbike_taxi_drivers WHERE tf_motorbike_taxi_drivers_deleted = 0";
    String MOTORBIKE_TAXI_DRIVERS_DELETE_ONE = "UPDATE tf_motorbike_taxi_drivers\n" +
            "SET tf_motorbike_taxi_drivers_deleted = 1\n" +
            "WHERE tf_motorbike_taxi_drivers_id = ?";

    String GET_ONE_DRIVER = "SELECT * FROM tf_motorbike_taxi_drivers\n" +
            "WHERE tf_motorbike_taxi_drivers_id = ?\n" +
            "  AND tf_motorbike_taxi_drivers_deleted = 0";

    String UPDATE_BUS = "UPDATE tf_bus\n" +
            "SET tf_bus_name = ?, tf_bus_start_time = ?,\n" +
            "    tf_bus_end_time = ?, tf_bus_price = ?,\n" +
            "    tf_bus_info = ?\n" +
            "WHERE tf_bus_id = ?";

    String UPDATE_DRIVER = "UPDATE tf_motorbike_taxi_drivers\n" +
            "SET tf_motorbike_taxi_drivers_name = ?, tf_motorbike_taxi_drivers_start_time = ?,\n" +
            "    tf_motorbike_taxi_drivers_end_time = ?, tf_motorbike_taxi_drivers_gender = ?,\n" +
            "    tf_motorbike_taxi_drivers_phone = ?, tf_motorbike_taxi_drivers_license_plates = ?,\n" +
            "    tf_motorbike_taxi_drivers_vehicle_type = ?\n" +
            "WHERE tf_motorbike_taxi_drivers_id = ?";

    String ADD_NEW_BUS = "INSERT INTO tf_bus (tf_bus_name, tf_bus_start_time,\n" +
            "                    tf_bus_end_time, tf_bus_info,\n" +
            "                    tf_bus_price, tf_bus_stops,\n" +
            "                    tf_bus_status, tf_bus_deleted)\n" +
            "                    VALUES  (?,?,?,?,?,'[\"BX Mỹ Đình\",\"Gần ngã 4 Phạm Hùng\",\"Nhà CT5 KĐT Sông Đà Mỹ Đình\"]',1,0)";

    String ADD_NEW_DRIVER = "INSERT INTO tf_motorbike_taxi_drivers( tf_motorbike_taxi_drivers_name,\n" +
            "                                      tf_motorbike_taxi_drivers_gender, tf_motorbike_taxi_drivers_phone,\n" +
            "                                      tf_motorbike_taxi_drivers_image, tf_motorbike_taxi_drivers_license_plates,\n" +
            "                                      tf_motorbike_taxi_drivers_vehicle_type, tf_motorbike_taxi_drivers_start_time,\n" +
            "                                      tf_motorbike_taxi_drivers_end_time, tf_motorbike_taxi_drivers_rating,\n" +
            "                                      tf_motorbike_taxi_drivers_status, tf_motorbike_taxi_drivers_deleted)\n" +
            "                                      VALUES (?,?,?,1,?,?,?,?,1,1,0)";
}
