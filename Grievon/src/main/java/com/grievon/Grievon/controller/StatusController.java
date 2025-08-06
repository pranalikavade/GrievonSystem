package com.grievon.Grievon.controller;

import com.grievon.Grievon.model.Status;
import com.grievon.Grievon.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statuses")
@CrossOrigin
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping
    public Status createStatus(@RequestBody Status status) {
        return statusService.createStatus(status);
    }

    @GetMapping
    public List<Status> getAllStatuses() {
        return statusService.getAllStatuses();
    }

    @GetMapping("/name/{name}")
    public Status getStatusByName(@PathVariable String name) {
        return statusService.getStatusByName(name);
    }
}
