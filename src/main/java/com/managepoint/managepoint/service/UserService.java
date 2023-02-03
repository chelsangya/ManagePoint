package com.managepoint.managepoint.service;

import com.managepoint.managepoint.entity.User;
import com.managepoint.managepoint.pojo.UserPojo;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String save(UserPojo userPojo);
    public String update(UserPojo userPojo);

    List<User> fetchAll();
    User fetchById(Integer id);
    void deleteById(Integer id);
//    void changePassword(PasswordChangePojo passwordChangePojo);
    UserPojo findByEmail(String email);

    Optional<User> getCurrentUser();
}
