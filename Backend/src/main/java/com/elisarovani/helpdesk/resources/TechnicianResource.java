package com.elisarovani.helpdesk.resources;

import com.elisarovani.helpdesk.domain.Technician;
import com.elisarovani.helpdesk.domain.dtos.TechnicianDto;
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
    public ResponseEntity<TechnicianDto> findById(@PathVariable Integer id){
        Technician obj = this.service.findById(id);
        return ResponseEntity.ok().body(new TechnicianDto(obj));
    }

    @GetMapping
    public ResponseEntity<List<TechnicianDto>> findAll(){
        List<Technician> list = service.findAll();
        List<TechnicianDto> listDto = list.stream().map(obj -> new TechnicianDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<TechnicianDto> create (@Valid @RequestBody TechnicianDto objDto){
        Technician newObj = service.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<TechnicianDto> update(@PathVariable Integer id, @Valid @RequestBody TechnicianDto objDto){
        Technician obj = service.update(id, objDto);
        return ResponseEntity.ok().body(new TechnicianDto(obj));
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<TechnicianDto> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}
