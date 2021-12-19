package com.holaland.holalandadmin.repository;

import com.holaland.holalandadmin.view.CountAllDashboard;
import org.springframework.dao.DataAccessException;

public interface CountAllDashboardRepository {

    CountAllDashboard count() throws DataAccessException;

}
