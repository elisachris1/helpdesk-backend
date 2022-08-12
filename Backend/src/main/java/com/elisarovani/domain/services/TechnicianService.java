package com.elisarovani.domain.services;

import com.elisarovani.domain.Technician;
import com.elisarovani.domain.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository repository;

    public Technician findById(Integer id){
        Optional<Technician> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
