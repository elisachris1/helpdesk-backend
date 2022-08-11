package com.elisarovani.domain;

import com.elisarovani.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Technician extends Person{
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "technician")
    private List<Call> calls = new ArrayList<>();

    public Technician(){
        super();
        addProfiles(Profile.CLIENT);
    }

    public Technician(Integer id, String name, String email, String password) {
        super(id, name, email, password);
        addProfiles(Profile.CLIENT);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }
}
