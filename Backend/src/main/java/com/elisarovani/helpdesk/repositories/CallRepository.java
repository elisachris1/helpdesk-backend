package com.elisarovani.helpdesk.repositories;

import com.elisarovani.helpdesk.domain.Call;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallRepository extends JpaRepository<Call, Integer> {

    
}
