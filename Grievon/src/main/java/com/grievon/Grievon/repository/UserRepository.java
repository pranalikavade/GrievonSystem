package com.grievon.Grievon.repository;

import com.grievon.Grievon.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);  // For login/authentication purpose
}
