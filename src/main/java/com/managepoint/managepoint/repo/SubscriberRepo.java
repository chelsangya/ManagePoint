package com.managepoint.managepoint.repo;


import com.managepoint.managepoint.entity.Subscriber;
import com.managepoint.managepoint.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SubscriberRepo extends JpaRepository<Subscriber,Integer> {
    Optional<Subscriber> findByEmail(String email);

    Optional<Subscriber> findByName(String name);
    @Query(value = "select * from SUBSCRIBERS where us_id=?1", nativeQuery = true)
    Subscriber findAllSub(Integer us_id);
}
