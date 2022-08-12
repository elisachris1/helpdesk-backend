package com.elisarovani.helpdesk.repositories;

import com.elisarovani.helpdesk.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {


}
