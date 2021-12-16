package com.holaland.holalandadmin.service.work;

import com.holaland.holalandadmin.entity.work.WorkSalaryUnit;
import org.springframework.dao.DataAccessException;

public interface WorkSalaryUnitService {

    WorkSalaryUnit getOne(int id) throws DataAccessException;
}
