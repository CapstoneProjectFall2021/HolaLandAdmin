package com.holaland.holalandadmin.repository.fptu;

public interface IRepositoryQuery {

    String FPTU_CLUB_GET_ALL = "SELECT * FROM fptu_club WHERE fptu_club_deleted = 0";

    String CLUB_TYPE_GET_ONE = "SELECT * FROM fptu_club_type WHERE fptu_club_type_id = ? AND fptu_club_type_deleted = 0";
}
