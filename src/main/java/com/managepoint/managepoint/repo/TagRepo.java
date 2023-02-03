package com.managepoint.managepoint.repo;


import com.managepoint.managepoint.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepo extends JpaRepository<Tag,Integer> {
    Optional<Tag> findByName(String Tagname);

}
