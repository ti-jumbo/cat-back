package com.jumboalimentos.SystemCallAndTask.controller;


import com.jumboalimentos.SystemCallAndTask.entities.Sector;
import com.jumboalimentos.SystemCallAndTask.controller.service.SectorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sector")
@CrossOrigin("*")
public class SectorController {
    @Autowired
    private SectorService sectorService;


    @PostMapping("newsector")
    public ResponseEntity<Sector> newSector(@Valid @RequestBody Sector sector) {
        try{
            Sector savedSector = sectorService.newSector(sector);
            return ResponseEntity.ok(savedSector);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("getsector/{name}")
    public List<Sector> getSector(@PathVariable String nameSector) {
        return sectorService.findByNameSector(nameSector);
    }

    @GetMapping("listsector")
    public List<Sector> getSectors() {
        return  sectorService.findAll();
    }

}

