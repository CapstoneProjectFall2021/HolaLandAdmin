package com.holaland.holalandadmin.repository.work;

import com.holaland.holalandadmin.entity.work.WorkRequestRecruitment;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface WorkRequestRecruitmentRepository {

    List<WorkRequestRecruitment> getAll() throws DataAccessException;
}
