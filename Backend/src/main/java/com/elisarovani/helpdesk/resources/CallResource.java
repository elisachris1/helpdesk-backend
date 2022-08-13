package com.elisarovani.helpdesk.resources;

import com.elisarovani.helpdesk.domain.Call;
import com.elisarovani.helpdesk.domain.dtos.CallDTO;
import com.elisarovani.helpdesk.services.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calls")
public class CallResource {

    @Autowired
    private CallService service;

    @GetMapping(value="/{id}")
    public ResponseEntity<CallDTO> findBYId(@PathVariable Integer id){
        Call obj = service.findById(id);
        return ResponseEntity.ok().body(new CallDTO(obj));
    }

}
