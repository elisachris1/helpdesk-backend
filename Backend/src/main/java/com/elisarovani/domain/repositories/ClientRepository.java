package com.elisarovani.domain.repositories;

import com.elisarovani.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    
}
