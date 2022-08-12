package com.elisarovani.helpdesk.repositories;


import com.elisarovani.helpdesk.domain.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, Integer> {

    
}
