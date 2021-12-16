package com.holaland.holalandadmin.service.work.impl;

import com.holaland.holalandadmin.entity.work.SttWork;
import com.holaland.holalandadmin.repository.work.SttWorkRepository;
import com.holaland.holalandadmin.service.work.SttWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class SttWorkServiceImpl implements SttWorkService {

    private final SttWorkRepository sttWorkRepository;

    @Autowired
    public SttWorkServiceImpl(SttWorkRepository sttWorkRepository) {
        this.sttWorkRepository = sttWorkRepository;
    }

    @Override
    public SttWork getOneByCode(int code) throws DataAccessException {
        return sttWorkRepository.getOneByCode(code);
    }
}
