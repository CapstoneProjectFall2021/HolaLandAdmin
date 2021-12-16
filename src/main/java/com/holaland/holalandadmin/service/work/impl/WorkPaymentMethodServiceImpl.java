package com.holaland.holalandadmin.service.work.impl;

import com.holaland.holalandadmin.entity.work.WorkPaymentMethod;
import com.holaland.holalandadmin.repository.work.WorkPaymentMethodRepository;
import com.holaland.holalandadmin.service.work.WorkPaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class WorkPaymentMethodServiceImpl implements WorkPaymentMethodService {

    private final WorkPaymentMethodRepository workPaymentMethodRepository;

    @Autowired
    public WorkPaymentMethodServiceImpl(WorkPaymentMethodRepository workPaymentMethodRepository) {
        this.workPaymentMethodRepository = workPaymentMethodRepository;
    }

    @Override
    public WorkPaymentMethod getOne(int id) throws DataAccessException {
        return workPaymentMethodRepository.getOne(id);
    }
}
