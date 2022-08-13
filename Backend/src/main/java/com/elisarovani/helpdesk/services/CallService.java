package com.elisarovani.helpdesk.services;

import com.elisarovani.helpdesk.domain.Call;
import com.elisarovani.helpdesk.repositories.CallRepository;
import com.elisarovani.helpdesk.services.exception.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CallService {

    @Autowired
    private CallRepository repository;

    public Call findById(Integer id){
        Optional<Call> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectnotFoundException("Object not found! ID " + id));
    }

    public List<Call> findAll() {

        return repository.findAll();
    }
}
