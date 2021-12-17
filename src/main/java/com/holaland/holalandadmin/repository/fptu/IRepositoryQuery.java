package com.holaland.holalandadmin.repository.fptu;

public interface IRepositoryQuery {

    String FPTU_CLUB_GET_ALL = "SELECT * FROM fptu_club WHERE fptu_club_deleted = 0";
    String FPTU_CLUB_GET_ONE = "SELECT * FROM fptu_club WHERE fptu_club_id = ? AND fptu_club_deleted = 0";
    String FPTU_CLUB_DELETE_ONE = "UPDATE fptu_club\n" +
            "SET fptu_club_deleted = 1\n" +
            "WHERE fptu_club_id = ?";

    String CLUB_TYPE_GET_ONE = "SELECT * FROM fptu_club_type WHERE fptu_club_type_id = ? AND fptu_club_type_deleted = 0";
}
