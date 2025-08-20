package com.jumboalimentos.SystemCallAndTask.controller.service;


import com.jumboalimentos.SystemCallAndTask.SoftwareRepository;
import com.jumboalimentos.SystemCallAndTask.entities.Software;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareService {
    @Autowired
    private SoftwareRepository SoftwareRepository;


    public Software newSoftware(Software Software) {
        if(Software == null) {
            throw new IllegalArgumentException("System cannot be null");
        }
        return SoftwareRepository.save(Software);
    }
    public List<Software> findByNameSoftware(String nameSoftware) {
        return SoftwareRepository.findByNameSoftware(nameSoftware);
    }
    public List<Software> findAll() {
        return SoftwareRepository.findAll();
    }
}
