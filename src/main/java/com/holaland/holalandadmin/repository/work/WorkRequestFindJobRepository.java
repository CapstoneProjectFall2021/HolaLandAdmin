package com.holaland.holalandadmin.repository.work;

import com.holaland.holalandadmin.entity.work.WorkRequestFindJob;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface WorkRequestFindJobRepository {

    List<WorkRequestFindJob> getAll() throws DataAccessException;

    WorkRequestFindJob getOne(int id) throws DataAccessException;

    boolean requestFindJobApprove(int id) throws DataAccessException;

    boolean cancel(WorkRequestFindJob obj) throws DataAccessException;

    boolean delete(int id) throws DataAccessException;
}
