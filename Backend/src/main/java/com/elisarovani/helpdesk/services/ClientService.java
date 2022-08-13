package com.elisarovani.helpdesk.services;

import com.elisarovani.helpdesk.domain.Client;
import com.elisarovani.helpdesk.domain.Person;
import com.elisarovani.helpdesk.domain.Technician;
import com.elisarovani.helpdesk.domain.dtos.ClientDto;
import com.elisarovani.helpdesk.domain.dtos.TechnicianDto;
import com.elisarovani.helpdesk.repositories.ClientRepository;
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
public class ClientService {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private PersonRepository personRepository;

    public Client findById(Integer id){
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Object not found! Id: " + id));
    }


    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client create(ClientDto objDto) {
        objDto.setId(null);
        validateByEmail(objDto);
        Client newObj = new Client(objDto);
        return repository.save(newObj);
    }
    public Client update(Integer id, @Valid ClientDto objDto) {
        objDto.setId(id);
        Client oldObj = findById(id);
        validateByEmail(objDto);
        oldObj = new Client(objDto);
        return repository.save(oldObj);

    }
    public void delete(Integer id) {
        Client obj = findById(id);
        if(obj.getCalls().size() > 0){
            throw new DataIntegrityViolationException("Client has calls and cannot be deleted!");
        }
            repository.deleteById(id);

    }

    private void validateByEmail(ClientDto objDto) {
        Optional<Person> obj = personRepository.findByEmail(objDto.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("Email already registered!");
        }

    }



}
