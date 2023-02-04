package com.managepoint.managepoint.repo;

import com.managepoint.managepoint.entity.BroadCast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroadCastRepo extends JpaRepository<BroadCast, Integer> {

}
