package com.holaland.holalandadmin.repository;

import com.holaland.holalandadmin.entity.Role;

import java.util.List;

public interface RoleRepository {

    List<Role> getRolesByUserEmail(String email);
}
