package com.elisarovani.helpdesk.services;

import com.elisarovani.helpdesk.domain.Technician;
import com.elisarovani.helpdesk.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository repository;

    public Technician findById(Integer id){
        Optional<Technician> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Object not found! Id: " + id));
    }
}
