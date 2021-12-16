package com.holaland.holalandadmin.repository.work;

import com.holaland.holalandadmin.entity.work.SttWork;
import org.springframework.dao.DataAccessException;

public interface SttWorkRepository {

    SttWork getOneByCode(int id) throws DataAccessException;
}
