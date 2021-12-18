package com.holaland.holalandadmin.service.impl;

import com.holaland.holalandadmin.entity.Role;
import com.holaland.holalandadmin.entity.UserRole;
import com.holaland.holalandadmin.repository.RoleRepository;
import com.holaland.holalandadmin.repository.UserRoleRepository;
import com.holaland.holalandadmin.service.UserRoleService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, RoleRepository roleRepository) {
        this.userRoleRepository = userRoleRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UserRole> getRole(int id) throws DataAccessException {
        return userRoleRepository.getRole(id);
    }

    @Override
    public List<Role> getRoleByUserId(int id) throws DataAccessException {
        return roleRepository.getRoleByUserId(id);
    }
}
