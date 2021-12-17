package com.holaland.holalandadmin.service.impl;

import com.holaland.holalandadmin.entity.UserRole;
import com.holaland.holalandadmin.repository.UserRoleRepository;
import com.holaland.holalandadmin.service.UserRoleService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole getRole(int id) throws DataAccessException {
        return userRoleRepository.getRole(id);
    }
}
