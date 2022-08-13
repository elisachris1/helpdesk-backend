package com.elisarovani.helpdesk.domain.dtos;
import com.elisarovani.helpdesk.domain.Call;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class CallDTO implements Serializable {
    public static final long serialVersionUID = 1l;

    private Integer id;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate openDate = LocalDate.now();
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate closeDate;
    @NotNull(message = "Priority is required")
    private Integer priority;

    private Integer status;
    @NotNull(message = "Title is required")
    private String title;
    @NotNull(message = "Observations are required")
    private String observations;
    @NotNull(message = "Technician is required")
    private Integer technician;
    @NotNull(message = "Client is required")
    private Integer client;
    private String nameTechnician;
    private String nameClient;

    public CallDTO(){
        super();
    }

    public CallDTO(Call obj) {
        this.id = obj.getId();
        this.openDate = obj.getOpenDate();
        this.closeDate = obj.getCloseDate();
        this.priority = obj.getPriority().getCode();
        this.status = obj.getStatus().getCode();
        this.title = obj.getTitle();
        this.observations = obj.getObservations();
        this.technician = obj.getTechnician().getId();
        this.client = obj.getClient().getId();
        this.nameTechnician = obj.getTechnician().getName();
        this.nameClient = obj.getClient().getName();
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public Integer getTechnician() {
        return technician;
    }

    public void setTechnician(Integer technician) {
        this.technician = technician;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public String getNameTechnician() {
        return nameTechnician;
    }

    public void setNameTechnician(String nameTechnician) {
        this.nameTechnician = nameTechnician;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
}
