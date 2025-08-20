package com.jumboalimentos.SystemCallAndTask;


import com.jumboalimentos.SystemCallAndTask.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogTasksRepository extends JpaRepository<Tasks, Long> {

}