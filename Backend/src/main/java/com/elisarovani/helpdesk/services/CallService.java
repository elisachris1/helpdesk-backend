package com.elisarovani.helpdesk.services;

import com.elisarovani.helpdesk.domain.Call;
import com.elisarovani.helpdesk.domain.Client;
import com.elisarovani.helpdesk.domain.Technician;
import com.elisarovani.helpdesk.domain.dtos.CallDTO;
import com.elisarovani.helpdesk.domain.enums.Priority;
import com.elisarovani.helpdesk.domain.enums.Status;
import com.elisarovani.helpdesk.repositories.CallRepository;
import com.elisarovani.helpdesk.services.exception.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CallService {

    @Autowired
    private CallRepository repository;
    @Autowired
    private TechnicianService technicianService;
    @Autowired
    private ClientService clientService;

    public Call findById(Integer id){
        Optional<Call> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectnotFoundException("Object not found! ID " + id));
    }

    public List<Call> findAll() {

        return repository.findAll();
    }

    public Call create(@Valid CallDTO objDTO) {
        return repository.save(newCall(objDTO));
    }

    public Call update(Integer id, CallDTO objDTO) {
        objDTO.setId(id);
        Call oldObj = findById(id);
        oldObj = newCall(objDTO);
        return repository.save(oldObj);
    }
    private Call newCall (CallDTO obj){
        Technician technician = technicianService.findById(obj.getTechnician());
        Client client = clientService.findById(obj.getClient());

        Call call = new Call();
        if(obj.getId() != null){
            call.setId((obj.getId()));
        }
        if (obj.getStatus().equals(2)){
            call.setCloseDate(LocalDate.now());
        }
        call.setTechnician(technician);
        call.setClient((client));
        call.setPriority(Priority.toEnum(obj.getPriority()));
       call.setStatus(Status.toEnum(obj.getStatus()));
        call.setTitle(obj.getTitle());
        call.getObservations();
        return call;
    }


}
