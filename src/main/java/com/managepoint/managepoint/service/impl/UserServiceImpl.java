package com.managepoint.managepoint.service.impl;

import com.managepoint.managepoint.model.User;
import com.managepoint.managepoint.pojo.UserPojo;
import com.managepoint.managepoint.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;

    @Override
    public String save(UserPojo userPojo) {
        User user = new User();
        if(userPojo.getU_id()!=null){
            user.setU_id(userPojo.getU_id());
        }
        user.setU_email(userPojo.getU_email());
        user.setU_name(userPojo.getU_name());
        user.setU_address(userPojo.getU_address());
        user.setU_password(userPojo.getU_password());
        user.setU_phone(userPojo.getU_phone());
        user.setU_image(userPojo.getU_image());
        userRepo.save(user);
        return "created";
//        return new UserPojo(user);
    }
    @Override
    public List<User> fetchAll() {
        return userRepo.findAll();
    }

    @Override
    public User fetchById(Integer id) {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }
}
