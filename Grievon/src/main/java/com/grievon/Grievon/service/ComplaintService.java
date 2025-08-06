package com.grievon.Grievon.service;

import com.grievon.Grievon.model.Complaint;
import com.grievon.Grievon.model.Status;
import com.grievon.Grievon.model.User;

import java.util.List;
import java.util.Optional;

public interface ComplaintService {
    Complaint createComplaint(Complaint complaint);
    List<Complaint> getAllComplaints();
    List<Complaint> getComplaintsByUser(User user);
    List<Complaint> getComplaintsByStatus(Status status);
    Optional<Complaint> getComplaintById(Long id);
    Complaint updateComplaint(Complaint complaint);
    void deleteComplaint(Long id);
}
