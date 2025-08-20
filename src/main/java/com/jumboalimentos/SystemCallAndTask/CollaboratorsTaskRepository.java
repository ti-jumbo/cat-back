package com.jumboalimentos.SystemCallAndTask;

import com.jumboalimentos.SystemCallAndTask.entities.CollaboratorsTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaboratorsTaskRepository extends JpaRepository<CollaboratorsTask, Long> {
}
