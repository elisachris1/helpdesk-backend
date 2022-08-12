package com.elisarovani.helpdesk.repositories;

import com.elisarovani.helpdesk.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByEmail(String email);
}
