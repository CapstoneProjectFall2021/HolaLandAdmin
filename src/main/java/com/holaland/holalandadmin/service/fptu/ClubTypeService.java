package com.holaland.holalandadmin.service.fptu;

import com.holaland.holalandadmin.entity.fptu.ClubType;
import org.springframework.dao.DataAccessException;

public interface ClubTypeService {

    ClubType getOne(int id) throws DataAccessException;
}
