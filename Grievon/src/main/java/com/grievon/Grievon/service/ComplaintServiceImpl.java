package com.grievon.Grievon.service;

import com.grievon.Grievon.model.Complaint;
import com.grievon.Grievon.model.Status;
import com.grievon.Grievon.model.User;
import com.grievon.Grievon.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public Complaint createComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public List<Complaint> getComplaintsByUser(User user) {
        return complaintRepository.findByUser(user);
    }

    @Override
    public List<Complaint> getComplaintsByStatus(Status status) {
        return complaintRepository.findByStatus(status);
    }

    @Override
    public Optional<Complaint> getComplaintById(Long id) {
        return complaintRepository.findById(id);
    }

    @Override
    public Complaint updateComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public void deleteComplaint(Long id) {
        complaintRepository.deleteById(id);
    }
}
