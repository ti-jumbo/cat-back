package com.jumboalimentos.SystemCallAndTask;

import com.jumboalimentos.SystemCallAndTask.entities.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoftwareRepository extends JpaRepository<Software, Long> {

    List<Software> findByNameSoftware(String nameSoftware);
}
