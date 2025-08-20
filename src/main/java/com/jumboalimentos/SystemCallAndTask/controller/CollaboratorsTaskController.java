package com.jumboalimentos.SystemCallAndTask.controller;


import com.jumboalimentos.SystemCallAndTask.controller.service.CollaboratorsTaskService;
import com.jumboalimentos.SystemCallAndTask.entities.CollaboratorsTask;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collaboratorstask")
@CrossOrigin("*")
public class CollaboratorsTaskController {
    @Autowired
    private CollaboratorsTaskService collaboratorsTaskService;


    @PostMapping("newcollaboratorstask")
    public ResponseEntity<CollaboratorsTask> newCollaboratorsTask(@Valid @RequestBody CollaboratorsTask collaboratorsTask) {
        try{
            CollaboratorsTask savedCollaboratorsTask = collaboratorsTaskService.newCollaboratorsTask(collaboratorsTask);
            return ResponseEntity.ok(savedCollaboratorsTask);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }


    @GetMapping("listcollaboratorstask")
    public List<CollaboratorsTask> getCollaboratorsTasks() {
        return  collaboratorsTaskService.findAll();
    }

}

