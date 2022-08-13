package com.elisarovani.helpdesk.services;

import com.elisarovani.helpdesk.domain.Person;
import com.elisarovani.helpdesk.domain.Technician;
import com.elisarovani.helpdesk.domain.dtos.TechnicianDto;
import com.elisarovani.helpdesk.repositories.PersonRepository;
import com.elisarovani.helpdesk.repositories.TechnicianRepository;
import com.elisarovani.helpdesk.services.exception.DataIntegrityViolationException;
import com.elisarovani.helpdesk.services.exception.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository repository;
    @Autowired
    private PersonRepository personRepository;

    public Technician findById(Integer id){
        Optional<Technician> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Object not found! Id: " + id));
    }


    public List<Technician> findAll() {
        return repository.findAll();
    }

    public Technician create(TechnicianDto objDto) {
        objDto.setId(null);
        validateByEmail(objDto);
        Technician newObj = new Technician(objDto);
        return repository.save(newObj);
    }
    public Technician update(Integer id, @Valid TechnicianDto objDto) {
        objDto.setId(id);
        Technician oldObj = findById(id);
        validateByEmail(objDto);
        oldObj = new Technician(objDto);
        return repository.save(oldObj);

    }
    public void delete(Integer id) {
        Technician obj = findById(id);
        if(obj.getCalls().size() > 0){
            throw new DataIntegrityViolationException("Technician has calls and cannot be deleted!");
        }
            repository.deleteById(id);

    }

    private void validateByEmail(TechnicianDto objDto) {
        Optional<Person> obj = personRepository.findByEmail(objDto.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("Email already registered!");
        }

    }



}
