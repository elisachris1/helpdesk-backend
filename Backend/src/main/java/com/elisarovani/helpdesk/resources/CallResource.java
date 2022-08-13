package com.elisarovani.helpdesk.resources;

import com.elisarovani.helpdesk.domain.Call;
import com.elisarovani.helpdesk.domain.dtos.CallDTO;
import com.elisarovani.helpdesk.services.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping
    public ResponseEntity<List<CallDTO>>findAll(){
        List<Call> list = service.findAll();
        List<CallDTO>listDTO = list.stream().map(obj -> new CallDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok(listDTO);
    }
    @PostMapping
    public ResponseEntity<CallDTO> create (@Valid @RequestBody CallDTO objDTO){
        Call obj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(objDTO.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<CallDTO> update(@PathVariable Integer id,@Valid @RequestBody CallDTO objDTO){
        Call newObj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new CallDTO(newObj));
    }
}
