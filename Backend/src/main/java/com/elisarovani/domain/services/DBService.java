package com.elisarovani.domain.services;
import com.elisarovani.domain.Call;
import com.elisarovani.domain.Client;
import com.elisarovani.domain.Technician;
import com.elisarovani.domain.enums.Priority;
import com.elisarovani.domain.enums.Profile;
import com.elisarovani.domain.enums.Status;
import com.elisarovani.domain.repositories.CallRepository;
import com.elisarovani.domain.repositories.ClientRepository;
import com.elisarovani.domain.repositories.TechnicianRepository;
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

    public void instanceDB(){

        Technician tec1 = new Technician(null, "John Doe", "jdoe@gmail.com", "johnny123");
        tec1.addProfiles(Profile.ADMIN);

        Client cli1 = new Client(null, "May Ann", "maryann@gmail.com", "mary123");

        Call c1 = new Call(null, Priority.MEDIUM, Status.ONGOING, "Call 01", "First Call", tec1, cli1);

        technicianRepository.saveAll(Arrays.asList(tec1));
        clientRepository.saveAll(Arrays.asList(cli1));
        callRepository.saveAll(Arrays.asList(c1));
    }
}
