package com.managepoint.managepoint.service.impl;

import com.managepoint.managepoint.repo.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService{
    private final UserRepo userRepo;


    @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            return (UserDetails) this.userRepo.findByEmail(email).orElseThrow(()->new EntityNotFoundException("user not found"));
        }
    }


