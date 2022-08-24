package com.elisarovani.helpdesk;
import com.elisarovani.helpdesk.domain.Call;
import com.elisarovani.helpdesk.domain.Client;
import com.elisarovani.helpdesk.domain.Technician;
import com.elisarovani.helpdesk.domain.enums.Priority;
import com.elisarovani.helpdesk.domain.enums.Profile;
import com.elisarovani.helpdesk.domain.enums.Status;
import com.elisarovani.helpdesk.repositories.CallRepository;
import com.elisarovani.helpdesk.repositories.ClientRepository;
import com.elisarovani.helpdesk.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication {

    @Autowired
    private TechnicianRepository technicianRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CallRepository callRepository;
public static void main(String[] args) {
        SpringApplication.run(HelpdeskApplication.class,args);
    }



    public void run(String... args) throws Exception {

        Technician tec1 = new Technician(null, "John Doe", "jdoe@gmail.com", "123");
        tec1.addProfiles(Profile.ADMIN);

        Technician tec2 = new Technician(null, "Richard Stallman", "stallman@mail.com", "123");
        tec1.addProfiles(Profile.ADMIN);

        Technician tec3 = new Technician(null, "Claude Elwood Shannon", "shannon@mail.com", "123");
        tec1.addProfiles(Profile.ADMIN);

        Technician tec4 = new Technician(null, "Tim Berners-Lee", "lee@mail.com", "123");
        tec1.addProfiles(Profile.ADMIN);

        Technician tec5 = new Technician(null, "Linus Torvalds", "linus@mail.com", "123");
        tec1.addProfiles(Profile.ADMIN);

        Client cli1 = new Client(null, "Albert Einstein",  "einstein@mail.com", "123");
        Client cli2 = new Client(null, "Marie Curie",  "curie@mail.com", "123");
        Client cli3 = new Client(null, "Charles Darwin", "darwin@mail.com", "123");
        Client cli4 = new Client(null, "Stephen Hawking",  "hawking@mail.com", "123");
        Client cli5 = new Client(null, "Max Planck", "planck@mail.com", "123");

        Call c1 = new Call(null, Priority.MEDIUM, Status.ONGOING, "Call 1", "Call test 1", tec1, cli1);
        Call c2 = new Call(null, Priority.HIGH, Status.OPEN, "Call 2", "Call test 2", tec1, cli2);
        Call c3 = new Call(null, Priority.LOW, Status.CLOSED, "Call 3", "Call test 3", tec2, cli3);
        Call c4 = new Call(null, Priority.HIGH, Status.OPEN, "Call 4", "Call test 4", tec3, cli3);
        Call c5 = new Call(null, Priority.MEDIUM, Status.ONGOING, "Call 5", "Call test 5", tec2, cli1);
        Call c6 = new Call(null, Priority.LOW, Status.ONGOING, "Call 6", "Call test 6", tec1, cli5);

        technicianRepository.saveAll(Arrays.asList(tec1,tec2,tec3,tec4,tec5));
        clientRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4,cli5));
        callRepository.saveAll(Arrays.asList(c1, c2,c3,c4,c5,c6));

    }

}