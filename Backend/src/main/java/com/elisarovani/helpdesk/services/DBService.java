package com.elisarovani.helpdesk.services;
import com.elisarovani.helpdesk.domain.Call;
import com.elisarovani.helpdesk.domain.Client;
import com.elisarovani.helpdesk.domain.Technician;
import com.elisarovani.helpdesk.domain.enums.Priority;
import com.elisarovani.helpdesk.domain.enums.Profile;
import com.elisarovani.helpdesk.domain.enums.Status;
import com.elisarovani.helpdesk.repositories.CallRepository;
import com.elisarovani.helpdesk.repositories.ClientRepository;
import com.elisarovani.helpdesk.repositories.PersonRepository;
import com.elisarovani.helpdesk.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TechnicianRepository technicianRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CallRepository callRepository;

    @Autowired
    private PersonRepository personRepository;

    public void instanceDB(){

        Technician tec1 = new Technician(null, "John Doe", "jdoe@gmail.com", "johnny123");
        tec1.addProfiles(Profile.ADMIN);

        Client cli1 = new Client(null, "May Ann", "maryann@gmail.com", "mary123");

        Call c1 = new Call(null, Priority.MEDIUM, Status.ONGOING, "Call 01", "First Call", tec1, cli1);

        technicianRepository.saveAll(Arrays.asList(tec1));
        clientRepository.saveAll(Arrays.asList(cli1));
        callRepository.saveAll(Arrays.asList(c1));
        personRepository.saveAll(Arrays.asList());
    }
}
