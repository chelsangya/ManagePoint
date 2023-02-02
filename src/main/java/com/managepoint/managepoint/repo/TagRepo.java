package com.managepoint.managepoint.repo;

import com.managepoint.managepoint.entity.User;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TagRepo extends JpaRepository<Tags,Integer> {
    @Query(value = "select * from TAGS where Tagname=?1", nativeQuery = true)
    Optional<Tags> findByName(String Name);

}
