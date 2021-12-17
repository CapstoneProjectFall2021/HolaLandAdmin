package com.holaland.holalandadmin.service.fptu.impl;

import com.holaland.holalandadmin.entity.fptu.Club;
import com.holaland.holalandadmin.repository.fptu.ClubRepository;
import com.holaland.holalandadmin.service.fptu.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<Club> getAll() throws DataAccessException {
        return clubRepository.getAll();
    }

    @Override
    public Club getOne(int id) throws DataAccessException {
        return clubRepository.getOne(id);
    }

    @Override
    public boolean delete(int id) throws DataAccessException {
        return clubRepository.delete(id);
    }
}
