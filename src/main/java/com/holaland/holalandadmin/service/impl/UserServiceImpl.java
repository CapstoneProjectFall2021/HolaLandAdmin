package com.holaland.holalandadmin.service.impl;

import com.holaland.holalandadmin.entity.CustomUser;
import com.holaland.holalandadmin.entity.Role;
import com.holaland.holalandadmin.entity.User;
import com.holaland.holalandadmin.repository.RoleRepository;
import com.holaland.holalandadmin.repository.UserRepository;
import com.holaland.holalandadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            System.out.println("User not found! " + email);
            throw new UsernameNotFoundException("User " + email + " was not found in the database");
        }
        System.out.println("USER: " + user.getUserEmail());

        //Get roles of user
        List<Role> roles = roleRepository.getRolesByUserEmail(email);

        // Create GrantedAuthority of Spring for role
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (roles != null) {
            for (Role role : roles) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
                grantedAuthorities.add(authority);
            }
        }
        System.out.println("Authorities: " + grantedAuthorities);

        // return object UserDetails of Spring
        return new CustomUser(
                user.getUserEmail(),
                user.getUserPassword(),
                grantedAuthorities,
                user.getUserId(),
                user.getUserPassword(),
                user.getUserCreateTime(),
                user.getUserStatusId(),
                user.isUserDeleted()
        );
    }

    @Override
    public boolean delete(int id) throws DataAccessException {
        return userRepository.delete(id);
    }
}
