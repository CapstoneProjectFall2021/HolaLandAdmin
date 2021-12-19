package com.holaland.holalandadmin.service.impl;

import com.holaland.holalandadmin.repository.CountAllDashboardRepository;
import com.holaland.holalandadmin.service.CountAllDashboardService;
import com.holaland.holalandadmin.view.CountAllDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CountAllDashboardServiceImpl implements CountAllDashboardService {

    private final CountAllDashboardRepository countAllDashboardRepository;

    @Autowired
    public CountAllDashboardServiceImpl(CountAllDashboardRepository countAllDashboardRepository) {
        this.countAllDashboardRepository = countAllDashboardRepository;
    }

    @Override
    public CountAllDashboard count() throws DataAccessException {
        return countAllDashboardRepository.count();
    }
}
