package com.grievon.Grievon.repository;

import com.grievon.Grievon.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByName(String name);
}
