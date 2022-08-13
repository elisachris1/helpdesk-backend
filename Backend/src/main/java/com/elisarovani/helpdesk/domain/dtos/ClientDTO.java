package com.elisarovani.helpdesk.domain.dtos;


import com.elisarovani.helpdesk.domain.Client;
import com.elisarovani.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO implements Serializable {

    private static final long serialVersionUID = 1L;

        protected Integer id;
        @NotNull(message = "Name is required")
        protected String name;
        @NotNull(message = "Email is required")
        protected String email;
        @NotNull(message = "Password is required")
        protected String password;
        protected Set<Integer> profiles = new HashSet<>();

        @JsonFormat(pattern = "yyyy/MM/dd")
        protected LocalDate dateCreated = LocalDate.now();

    public ClientDTO(){

        super();
        addProfile(Profile.CLIENT);
    }
    public ClientDTO(Client obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.profiles = obj.getProfiles().stream().map(x -> x.getCode()).collect(Collectors.toSet());
        this.dateCreated = obj.getDateCreated();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Profile> getProfiles() {
        return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile.getCode());
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
