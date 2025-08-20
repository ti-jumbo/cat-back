package com.jumboalimentos.SystemCallAndTask.controller.service;


import com.jumboalimentos.SystemCallAndTask.SectorRepository;
import com.jumboalimentos.SystemCallAndTask.entities.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorService {
    @Autowired
    private SectorRepository SectorRepository;


    public Sector newSector(Sector sector) {
        if(sector == null) {
            throw new IllegalArgumentException("Sector cannot be null");
        }
        return SectorRepository.save(sector);
    }
    public List<Sector> findByNameSector(String nameSector) {
        return SectorRepository.findByNameSector(nameSector);
    }
    public List<Sector> findAll() {
        return SectorRepository.findAll();
    }
}
