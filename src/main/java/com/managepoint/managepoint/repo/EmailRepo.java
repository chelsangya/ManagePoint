package com.managepoint.managepoint.repo;

import com.managepoint.managepoint.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailRepo extends JpaRepository<Email,Integer> {
    Optional<Email> findByTitle(String name);
    Optional<Email> findByStatus(String name);
}
