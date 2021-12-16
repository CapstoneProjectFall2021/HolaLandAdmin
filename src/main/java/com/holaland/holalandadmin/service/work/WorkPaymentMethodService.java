package com.holaland.holalandadmin.service.work;

import com.holaland.holalandadmin.entity.work.WorkPaymentMethod;
import org.springframework.dao.DataAccessException;

public interface WorkPaymentMethodService {

    WorkPaymentMethod getOne(int id) throws DataAccessException;
}
