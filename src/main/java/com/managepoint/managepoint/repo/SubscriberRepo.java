package com.managepoint.managepoint.repo;


import com.managepoint.managepoint.entity.Subscriber;
import com.managepoint.managepoint.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriberRepo extends JpaRepository<Subscriber,Integer> {
    Optional<Subscriber> findByEmail(String email);

    Optional<Subscriber> findByName(String name);
}
