package com.grievon.Grievon.service;

import com.grievon.Grievon.model.Status;

import java.util.List;

public interface StatusService {
    Status createStatus(Status status);
    List<Status> getAllStatuses();
    Status getStatusByName(String name);
}
