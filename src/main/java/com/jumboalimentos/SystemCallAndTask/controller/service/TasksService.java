package com.jumboalimentos.SystemCallAndTask.controller.service;

import com.jumboalimentos.SystemCallAndTask.entities.Tasks; // Renamed for clarity
import com.jumboalimentos.SystemCallAndTask.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    @Autowired
    private TasksRepository TasksRepository;

    // Create a new Tasks with validation
    public Tasks createTasks(Tasks Tasks) {
        if (Tasks == null) {
            throw new IllegalArgumentException("Tasks cannot be null");
        }
        Tasks.setCreatedAt(LocalDateTime.now());
        return TasksRepository.save(Tasks);
    }

    // Retrieve all Taskss
    public List<Tasks> findByEmail(String email) {
        return TasksRepository.findByEmail(email);
    }

    // Update an existing Tasks (PATCH-like behavior)
    public Tasks updateTasks(Long id, Tasks updatedTasks) {
        if (id == null || updatedTasks == null) {
            throw new IllegalArgumentException("Tasks ID and updated Tasks cannot be null");
        }

        Optional<Tasks> existingTasks = TasksRepository.findById(id);
        if (existingTasks.isPresent()) {
            Tasks Tasks = existingTasks.get();
            // Update only non-null fields (example for PATCH)
            if (updatedTasks.getSector_responsible_id() != null) {
                Tasks.setSector_responsible_id(updatedTasks.getSector_responsible_id());
            }
            if (updatedTasks.getSystem_id() != null) {
                Tasks.setSystem_id(updatedTasks.getSystem_id());
            }
            if (updatedTasks.getStatus_id() != null) {
                Tasks.setStatus_id(updatedTasks.getStatus_id());
            }
            if(updatedTasks.getDescription() != null) {
                Tasks.setDescription(updatedTasks.getDescription());
            }
            if(updatedTasks.getCompletionDate() != null) {
                Tasks.setCompletionDate(updatedTasks.getCompletionDate());
            }
            if(updatedTasks.getEstimedDate() != null) {
                Tasks.setEstimedDate(updatedTasks.getEstimedDate());
            }
                    // Add other fields as needed
            return TasksRepository.saveAndFlush(Tasks);
        } else {
            throw new RuntimeException("Tasks with ID " + id + " not found");
        }
    }
}