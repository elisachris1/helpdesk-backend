package com.elisarovani.helpdesk.domain;

import com.elisarovani.helpdesk.domain.dtos.ClientDTO;
import com.elisarovani.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Client extends Person {
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Call> calls = new ArrayList<>();

    public Client() {

        super();
        addProfiles(Profile.CLIENT);
    }

    public Client(Integer id, String name, String email, String password) {
        super(id, name, email, password);

    }
    public Client(ClientDTO obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.profiles = obj.getProfiles().stream().map(x -> x.getCode()).collect(Collectors.toSet());
        this.dateCreated = obj.getDateCreated();
    }

    public List<Call> getCalls() {
        return calls;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }
}
