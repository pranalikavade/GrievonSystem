package com.grievon.Grievon.controller;

import com.grievon.Grievon.model.Complaint;
import com.grievon.Grievon.model.Status;
import com.grievon.Grievon.model.User;
import com.grievon.Grievon.service.ComplaintService;
import com.grievon.Grievon.service.StatusService;
import com.grievon.Grievon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private UserService userService;

    @Autowired
    private StatusService statusService;

    @PostMapping
    public Complaint createComplaint(@RequestBody Complaint complaint) {
        return complaintService.createComplaint(complaint);
    }

    @GetMapping
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    @GetMapping("/{id}")
    public Optional<Complaint> getComplaintById(@PathVariable Long id) {
        return complaintService.getComplaintById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Complaint> getComplaintsByUser(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(complaintService::getComplaintsByUser).orElse(null);
    }

    @GetMapping("/status/{statusName}")
    public List<Complaint> getComplaintsByStatus(@PathVariable String statusName) {
        Status status = statusService.getStatusByName(statusName);
        return complaintService.getComplaintsByStatus(status);
    }

    @PutMapping
    public Complaint updateComplaint(@RequestBody Complaint complaint) {
        return complaintService.updateComplaint(complaint);
    }

    @DeleteMapping("/{id}")
    public void deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
    }
}
