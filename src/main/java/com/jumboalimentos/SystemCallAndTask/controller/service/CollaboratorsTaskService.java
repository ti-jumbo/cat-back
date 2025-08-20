package com.jumboalimentos.SystemCallAndTask.controller.service;


import com.jumboalimentos.SystemCallAndTask.CollaboratorsTaskRepository;
import com.jumboalimentos.SystemCallAndTask.entities.CollaboratorsTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaboratorsTaskService {
    @Autowired
    private CollaboratorsTaskRepository CollaboratorsTaskRepository;


    public CollaboratorsTask newCollaboratorsTask(CollaboratorsTask collaboratorsTask) {
        if(collaboratorsTask == null) {
            throw new IllegalArgumentException("Sector cannot be null");
        }
        return CollaboratorsTaskRepository.save(collaboratorsTask);
    }

    public List<CollaboratorsTask> findAll() {
        return CollaboratorsTaskRepository.findAll();
    }
}
