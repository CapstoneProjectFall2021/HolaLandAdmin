package com.holaland.holalandadmin.repository.work;

import com.holaland.holalandadmin.entity.work.WorkSalaryUnit;
import org.springframework.dao.DataAccessException;

public interface WorkSalaryUnitRepository {

    WorkSalaryUnit getOne(int id) throws DataAccessException;
}
