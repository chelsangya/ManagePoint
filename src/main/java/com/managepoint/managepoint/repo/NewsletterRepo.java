package com.managepoint.managepoint.repo;


import com.managepoint.managepoint.entity.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsletterRepo extends JpaRepository<Newsletter,Integer> {
    Optional<Newsletter> findByName(String name);
    Optional<Newsletter> findByAuthor(String name);
    Optional<Newsletter> findByTitle(String name);
}
