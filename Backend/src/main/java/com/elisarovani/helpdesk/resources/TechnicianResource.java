package com.elisarovani.helpdesk.resources;

import com.elisarovani.helpdesk.domain.Technician;
import com.elisarovani.helpdesk.domain.dtos.TechnicianDTO;
import com.elisarovani.helpdesk.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/technicians")
public class TechnicianResource {

    // localhost:8080/technicians/1
    @Autowired
    private TechnicianService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnicianDTO> findById(@PathVariable Integer id){
        Technician obj = this.service.findById(id);
        return ResponseEntity.ok().body(new TechnicianDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<TechnicianDTO>> findAll(){
        List<Technician> list = service.findAll();
        List<TechnicianDTO> listDto = list.stream().map(obj -> new TechnicianDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<TechnicianDTO> create (@Valid @RequestBody TechnicianDTO objDto){
        Technician newObj = service.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<TechnicianDTO> update(@PathVariable Integer id, @Valid @RequestBody TechnicianDTO objDto){
        Technician obj = service.update(id, objDto);
        return ResponseEntity.ok().body(new TechnicianDTO(obj));
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<TechnicianDTO> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}
