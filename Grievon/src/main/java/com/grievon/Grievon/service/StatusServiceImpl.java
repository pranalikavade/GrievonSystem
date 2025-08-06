package com.grievon.Grievon.service;

import com.grievon.Grievon.model.Status;
import com.grievon.Grievon.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    @Override
    public Status getStatusByName(String name) {
        return statusRepository.findByName(name);
    }
}
