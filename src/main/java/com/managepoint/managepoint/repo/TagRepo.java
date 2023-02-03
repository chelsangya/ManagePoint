package com.managepoint.managepoint.repo;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TagRepo extends JpaRepository<Tag,Integer> {
    @Query(value = "select * from TAGS where Tagname=?1", nativeQuery = true)
    Optional<Tags> findByName(String Tagname);

}
