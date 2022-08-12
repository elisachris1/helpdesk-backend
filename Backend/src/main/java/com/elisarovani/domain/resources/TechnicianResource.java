package com.elisarovani.domain.resources;

import com.elisarovani.domain.Technician;
import com.elisarovani.domain.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/technicians")
public class TechnicianResource {

    // localhost:8080/technicians/1
    @Autowired
    private TechnicianService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Technician> findById(@PathVariable Integer id){
        Technician obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
