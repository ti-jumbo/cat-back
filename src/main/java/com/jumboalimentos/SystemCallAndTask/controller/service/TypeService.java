package com.jumboalimentos.SystemCallAndTask.controller.service;


import com.jumboalimentos.SystemCallAndTask.TypeRepository;
import com.jumboalimentos.SystemCallAndTask.entities.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository TypeRepository;


    public Type createType(Type type) {
        if(type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }
        return TypeRepository.save(type);
    }
    public List<Type> findByNameType(String nameType) {
        return TypeRepository.findByNameType(nameType);
    }
    public List<Type> findAll() {
        return TypeRepository.findAll();
    }
}
