package com.holaland.holalandadmin.service.work;

import com.holaland.holalandadmin.entity.work.WorkRequestFindJob;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface WorkRequestFindJobService {

    List<WorkRequestFindJob> getAll() throws DataAccessException;

    WorkRequestFindJob getOne(int id) throws DataAccessException;

    boolean delete(int id) throws DataAccessException;
}
