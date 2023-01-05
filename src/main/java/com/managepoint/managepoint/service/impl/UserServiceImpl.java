package com.managepoint.managepoint.service.impl;

import com.managepoint.managepoint.config.PasswordEncoderUtil;
import com.managepoint.managepoint.exception.AppException;
import com.managepoint.managepoint.entity.User;
import com.managepoint.managepoint.pojo.PasswordChangePojo;
import com.managepoint.managepoint.pojo.UserPojo;
import com.managepoint.managepoint.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void changePassword(PasswordChangePojo passwordChangePojo) {
        Optional<User> optionalUser = userRepo.findByEmail(passwordChangePojo.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (PasswordEncoderUtil.getInstance().matches(passwordChangePojo.getOldPassword(), user.getU_password())) {
                if (passwordChangePojo.getNewPassword().equals(passwordChangePojo.getRepeatPassword())) {
                    user.setU_password(PasswordEncoderUtil.getInstance().encode(passwordChangePojo.getNewPassword()));
                    userRepo.save(user);
                } else {
                    throw new AppException("New Password doesn't match.", HttpStatus.BAD_REQUEST);
                }

            } else {
                throw new AppException("Old Password doesn't match existing password.", HttpStatus.BAD_REQUEST);
            }
        }
    }
}
