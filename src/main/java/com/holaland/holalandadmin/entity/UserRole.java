package com.holaland.holalandadmin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserRole {

    private int userRoleId;
    private User user;
    private Role role;
    private int userId;
    private int roleId;
}
