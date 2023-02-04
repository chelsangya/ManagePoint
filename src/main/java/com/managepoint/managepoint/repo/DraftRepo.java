package com.managepoint.managepoint.repo;

import com.managepoint.managepoint.entity.BroadCast;
import com.managepoint.managepoint.entity.Draft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DraftRepo extends JpaRepository<Draft, Integer> {

}
