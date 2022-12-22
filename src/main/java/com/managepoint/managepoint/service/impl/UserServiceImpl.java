package com.managepoint.managepoint.service.impl;

import com.managepoint.managepoint.model.User;
import com.managepoint.managepoint.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    @Override
    public List<User> fetchAll() {
        return this.userRepo.findAll();
    }
}
