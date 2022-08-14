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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.image.BandCombineOp;
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
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanceDB(){

        Technician tec1 = new Technician(null, "John Doe", "jdoe@gmail.com", encoder.encode("123"));
        tec1.addProfiles(Profile.ADMIN);

        Technician tec2 = new Technician(null, "Richard Stallman", "stallman@mail.com", encoder.encode("123"));
        tec1.addProfiles(Profile.ADMIN);

        Technician tec3 = new Technician(null, "Claude Elwood Shannon", "shannon@mail.com", encoder.encode("123"));
        tec1.addProfiles(Profile.ADMIN);

        Technician tec4 = new Technician(null, "Tim Berners-Lee", "lee@mail.com", encoder.encode("123"));
        tec1.addProfiles(Profile.ADMIN);

        Technician tec5 = new Technician(null, "Linus Torvalds", "linus@mail.com", encoder.encode("123"));
        tec1.addProfiles(Profile.ADMIN);

        Client cli1 = new Client(null, "Albert Einstein",  "einstein@mail.com", encoder.encode("123"));
        Client cli2 = new Client(null, "Marie Curie",  "curie@mail.com", encoder.encode("123"));
        Client cli3 = new Client(null, "Charles Darwin", "darwin@mail.com", encoder.encode("123"));
        Client cli4 = new Client(null, "Stephen Hawking",  "hawking@mail.com", encoder.encode("123"));
        Client cli5 = new Client(null, "Max Planck", "planck@mail.com", encoder.encode("123"));

        Call c1 = new Call(null, Priority.MEDIUM, Status.ONGOING, "Call 1", "Call test 1", tec1, cli1);
        Call c2 = new Call(null, Priority.HIGH, Status.OPEN, "Call 2", "Call test 2", tec1, cli2);
        Call c3 = new Call(null, Priority.LOW, Status.CLOSED, "Call 3", "Call test 3", tec2, cli3);
        Call c4 = new Call(null, Priority.HIGH, Status.OPEN, "Call 4", "Call test 4", tec3, cli3);
        Call c5 = new Call(null, Priority.MEDIUM, Status.ONGOING, "Call 5", "Call test 5", tec2, cli1);
        Call c6 = new Call(null, Priority.LOW, Status.ONGOING, "Call 6", "Call test 6", tec1, cli5);

        technicianRepository.saveAll(Arrays.asList(tec1));
        clientRepository.saveAll(Arrays.asList(cli1));
        callRepository.saveAll(Arrays.asList(c1));
        personRepository.saveAll(Arrays.asList());
    }
}
