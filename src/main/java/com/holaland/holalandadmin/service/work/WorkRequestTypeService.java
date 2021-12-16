package com.holaland.holalandadmin.service.work;

import com.holaland.holalandadmin.entity.work.WorkRequestType;
import org.springframework.dao.DataAccessException;

public interface WorkRequestTypeService {

    WorkRequestType getOne(int id) throws DataAccessException;
}
