package com.jumboalimentos.SystemCallAndTask.controller;


import com.jumboalimentos.SystemCallAndTask.entities.Status;
import com.jumboalimentos.SystemCallAndTask.controller.service.StatusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
@CrossOrigin("*")
public class StatusController {
    @Autowired
    private StatusService StatusService;


    @PostMapping("newstatus")
    public ResponseEntity<Status> createStatus(@Valid @RequestBody Status Status) {
        try{
            Status savedStatus = StatusService.createStatus(Status);
            return ResponseEntity.ok(savedStatus);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("getstatus/{name}")
    public List<Status> getStatus(@PathVariable String nameStatus) {
        return StatusService.findByNameStatus(nameStatus);
    }

    @GetMapping("liststatus")
    public List<Status> getStatus() {
        return  StatusService.findAll();
    }

}

