package com.elisarovani.helpdesk.repositories;

import com.elisarovani.helpdesk.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    
}
