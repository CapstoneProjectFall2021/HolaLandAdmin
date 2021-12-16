package com.holaland.holalandadmin.service.work;

import com.holaland.holalandadmin.entity.work.WorkTime;
import org.springframework.dao.DataAccessException;

public interface WorkTimeService {

    WorkTime getOne(int id) throws DataAccessException;
}
