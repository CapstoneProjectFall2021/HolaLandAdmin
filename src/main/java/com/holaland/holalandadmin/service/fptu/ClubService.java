package com.holaland.holalandadmin.service.fptu;

import com.holaland.holalandadmin.entity.fptu.Club;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ClubService {

    List<Club> getAll() throws DataAccessException;

    Club getOne(int id) throws DataAccessException;

    boolean delete(int id) throws DataAccessException;
}
