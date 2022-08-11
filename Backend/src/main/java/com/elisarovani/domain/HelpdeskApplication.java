package com.elisarovani.domain;


import com.elisarovani.domain.enums.Priority;
import com.elisarovani.domain.enums.Profile;
import com.elisarovani.domain.enums.Status;
import com.elisarovani.domain.repositories.CallRepository;
import com.elisarovani.domain.repositories.ClientRepository;
import com.elisarovani.domain.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner{
@Autowired
private TechnicianRepository technicianRepository;
@Autowired
private ClientRepository clientRepository;
@Autowired
private CallRepository callRepository;
public static void main(String[] args) {
        SpringApplication.run(HelpdeskApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
    Technician tec1 = new Technician(null, "John Doe", "jdoe@gmail.com", "johnny123");
    tec1.addProfiles(Profile.ADMIN);

    Client cli1 = new Client(null, "May Ann", "maryann@gmail.com", "mary123");

    Call c1 = new Call(null, Priority.MEDIUM, Status.ONGOING, "Call 01", "First Call", tec1, cli1);

    technicianRepository.saveAll(Arrays.asList(tec1));
    clientRepository.saveAll(Arrays.asList(cli1));
    callRepository.saveAll(Arrays.asList(c1));
    }
}
