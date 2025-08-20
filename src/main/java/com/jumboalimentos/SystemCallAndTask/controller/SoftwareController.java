package com.jumboalimentos.SoftwareCallAndTask.controller;


import com.jumboalimentos.SystemCallAndTask.entities.Software;
import com.jumboalimentos.SystemCallAndTask.entities.Software;
import com.jumboalimentos.SystemCallAndTask.controller.service.SoftwareService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Software")
@CrossOrigin("*")
public class SoftwareController {
    @Autowired
    private SoftwareService SoftwareService;


    @PostMapping("newSoftware")
    public ResponseEntity<Software> newSoftware(@Valid @RequestBody Software software) {
        try{
            Software savedSoftware = SoftwareService.newSoftware(software);
            return ResponseEntity.ok(savedSoftware);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("getSoftware/{name}")
    public List<Software> getSoftware(@PathVariable String nameSoftware) {
        return SoftwareService.findByNameSoftware(nameSoftware);
    }

    @GetMapping("listSoftware")
    public List<Software> getSoftware() {
        return  SoftwareService.findAll();
    }

}

