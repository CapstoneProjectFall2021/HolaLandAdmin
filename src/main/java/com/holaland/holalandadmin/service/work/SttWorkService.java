package com.holaland.holalandadmin.service.work;

import com.holaland.holalandadmin.entity.work.SttWork;
import org.springframework.dao.DataAccessException;

public interface SttWorkService {

    SttWork getOneByCode(int id) throws DataAccessException;
}
