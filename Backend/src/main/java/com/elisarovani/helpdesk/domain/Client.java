package com.elisarovani.helpdesk.domain;

import com.elisarovani.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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

    public List<Call> getCalls() {
        return calls;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }
}