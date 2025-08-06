package com.grievon.Grievon.repository;

import com.grievon.Grievon.model.Complaint;
import com.grievon.Grievon.model.User;
import com.grievon.Grievon.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByUser(User user);
    List<Complaint> findByStatus(Status status);
}
