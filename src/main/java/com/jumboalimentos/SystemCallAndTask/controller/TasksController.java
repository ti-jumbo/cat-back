package com.jumboalimentos.SystemCallAndTask.controller;

import com.jumboalimentos.SystemCallAndTask.entities.Tasks;
import com.jumboalimentos.SystemCallAndTask.controller.service.TasksService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Tasks")
@CrossOrigin(origins = "*")
public class TasksController {
    private static final Logger logger = LoggerFactory.getLogger(TasksController.class);

    @Autowired
    private TasksService TasksService;

    @PostMapping("/getTasks")
    public ResponseEntity<List<Tasks>> getTasks(@RequestParam String email) {
        try {
            List<Tasks> Tasks = TasksService.findByEmail(email);
            return ResponseEntity.ok(Tasks);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/createTasks")
    public ResponseEntity<Tasks> createTasks(@Valid @RequestBody Tasks Tasks) {
        try {
            Tasks savedTasks = TasksService.createTasks(Tasks);
            return ResponseEntity.ok(savedTasks);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PatchMapping("/updateTasks/{id}")
    public ResponseEntity<Tasks> updateTasks(@PathVariable Long id, @Valid @RequestBody Tasks Tasks) {
        try {
            Tasks updatedTasks = TasksService.updateTasks(id, Tasks);
            return ResponseEntity.ok(updatedTasks);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}