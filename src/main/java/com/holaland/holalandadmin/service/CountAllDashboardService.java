package com.holaland.holalandadmin.service;

import com.holaland.holalandadmin.view.CountAllDashboard;
import org.springframework.dao.DataAccessException;

public interface CountAllDashboardService {

    CountAllDashboard count() throws DataAccessException;

}
