package com.managepoint.managepoint.repo;

import com.managepoint.managepoint.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
