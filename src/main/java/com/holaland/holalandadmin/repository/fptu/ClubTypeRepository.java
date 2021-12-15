package com.holaland.holalandadmin.repository.fptu;

import com.holaland.holalandadmin.entity.fptu.ClubType;
import org.springframework.dao.DataAccessException;

public interface ClubTypeRepository {

    ClubType getOne(int id) throws DataAccessException;
}
