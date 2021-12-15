package com.holaland.holalandadmin.service.fptu.impl;

import com.holaland.holalandadmin.entity.fptu.ClubType;
import com.holaland.holalandadmin.repository.fptu.ClubTypeRepository;
import com.holaland.holalandadmin.service.fptu.ClubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubTypeServiceImpl implements ClubTypeService {

    private final ClubTypeRepository clubTypeRepository;

    @Autowired
    public ClubTypeServiceImpl(ClubTypeRepository clubTypeRepository) {
        this.clubTypeRepository = clubTypeRepository;
    }

    @Override
    public ClubType getOne(int id) throws DataAccessException {
        return clubTypeRepository.getOne(id);
    }
}
