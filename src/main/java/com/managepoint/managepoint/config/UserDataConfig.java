package com.managepoint.managepoint.config;

import com.managepoint.managepoint.entity.User;
import com.managepoint.managepoint.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDataConfig {

    private final UserRepo userRepo;

    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        if(userEmail == null) {
            throw new RuntimeException("Not authenticated");
        }
        User user = userRepo.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not logged in"));
        return user;
    }
}
