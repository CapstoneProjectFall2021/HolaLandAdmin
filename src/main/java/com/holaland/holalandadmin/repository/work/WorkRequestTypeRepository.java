package com.holaland.holalandadmin.repository.work;

import com.holaland.holalandadmin.entity.work.WorkRequestType;
import org.springframework.dao.DataAccessException;

public interface WorkRequestTypeRepository {

    WorkRequestType getOne(int id) throws DataAccessException;
}
