package com.holaland.holalandadmin.repository.work;

import com.holaland.holalandadmin.entity.work.WorkTime;
import org.springframework.dao.DataAccessException;

public interface WorkTimeRepository {

    WorkTime getOne(int id) throws DataAccessException;
}
