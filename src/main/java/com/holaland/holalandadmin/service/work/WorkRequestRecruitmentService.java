package com.holaland.holalandadmin.service.work;

import com.holaland.holalandadmin.entity.work.WorkRequestRecruitment;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface WorkRequestRecruitmentService {

    List<WorkRequestRecruitment> getAll() throws DataAccessException;
}
