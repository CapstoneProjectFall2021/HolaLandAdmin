package com.holaland.holalandadmin.repository.work;

import com.holaland.holalandadmin.entity.work.WorkPaymentMethod;
import org.springframework.dao.DataAccessException;

public interface WorkPaymentMethodRepository {

    WorkPaymentMethod getOne(int id) throws DataAccessException;
}
