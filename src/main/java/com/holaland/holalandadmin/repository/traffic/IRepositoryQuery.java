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
}
