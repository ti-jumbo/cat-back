package com.jumboalimentos.SystemCallAndTask.controller.service;
import com.jumboalimentos.SystemCallAndTask.StatusRepository;
import com.jumboalimentos.SystemCallAndTask.entities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    @Autowired
    private StatusRepository StatusRepository;


    public Status createStatus(Status Status) {
        if(Status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        return StatusRepository.save(Status);
    }
    public List<Status> findByNameStatus(String nameStatus) {
        return StatusRepository.findByNameStatus(nameStatus);
    }
    public List<Status> findAll() {
        return StatusRepository.findAll();
    }
}
