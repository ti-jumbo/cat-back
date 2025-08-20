package com.jumboalimentos.SystemCallAndTask.controller;


import com.jumboalimentos.SystemCallAndTask.entities.Type;
import com.jumboalimentos.SystemCallAndTask.controller.service.TypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Type")
@CrossOrigin("*")
public class TypeController {
    @Autowired
    private TypeService TypeService;


    @PostMapping("createType")
    public ResponseEntity<Type> createType(@Valid @RequestBody Type Type) {
        try{
            Type savedType = TypeService.createType(Type);
            return ResponseEntity.ok(savedType);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("getType/{name}")
    public List<Type> getType(@PathVariable String nameType) {
        return TypeService.findByNameType(nameType);
    }

    @GetMapping("listType")
    public List<Type> getTypes() {
        return  TypeService.findAll();
    }

}

