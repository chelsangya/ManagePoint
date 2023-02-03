package com.managepoint.managepoint.repo;


import com.managepoint.managepoint.entity.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsletterRepo extends JpaRepository<Newsletter,Integer> {
    Optional<Newsletter> findByAuthor(String author);
    Optional<Newsletter> findByTitle(String title);
}
