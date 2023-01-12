package com.managepoint.managepoint.service;

import com.managepoint.managepoint.entity.User;
import com.managepoint.managepoint.pojo.PasswordChangePojo;
import com.managepoint.managepoint.pojo.UserPojo;

import java.util.List;

public interface UserService {
    String save(UserPojo userPojo);

    List<User> fetchAll();
    User fetchById(Integer id);
    void deleteById(Integer id);
//    void changePassword(PasswordChangePojo passwordChangePojo);

    UserPojo findByEmail(String u_email);

}
