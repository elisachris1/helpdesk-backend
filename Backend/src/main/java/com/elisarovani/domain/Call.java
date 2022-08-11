package com.elisarovani.domain;

import com.elisarovani.domain.enums.Priority;
import com.elisarovani.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Call implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate openDate = LocalDate.now();
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate closeDate;
    private Priority priority;
    private Status status;
    private String title;
    private String observations;

    @ManyToOne
    @JoinColumn(name = "Technician_id")
    private Technician technician;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    public Call(){
        super();
    }

    public Call(Integer id, Priority priority, Status status, String title, String observations, Technician technician, Client client) {
        super();
        this.id = id;
        this.priority = priority;
        this.status = status;
        this.title = title;
        this.observations = observations;
        this.technician = technician;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Call call = (Call) obj;
        return id.equals(call.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
