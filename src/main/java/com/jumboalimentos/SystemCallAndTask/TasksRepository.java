package com.jumboalimentos.SystemCallAndTask;


import com.jumboalimentos.SystemCallAndTask.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TasksRepository extends JpaRepository<Tasks, Long> {
    boolean existsByEmail(String email);

    List<Tasks> findByEmail(String email);
}