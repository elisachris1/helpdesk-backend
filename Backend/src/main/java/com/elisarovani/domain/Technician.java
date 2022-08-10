package com.elisarovani.domain;

import java.util.ArrayList;
import java.util.List;

public class Technician extends Person{

    private List<Call> calls = new ArrayList<>();

    public Technician(){
        super();
    }

    public Technician(Integer id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }
}
