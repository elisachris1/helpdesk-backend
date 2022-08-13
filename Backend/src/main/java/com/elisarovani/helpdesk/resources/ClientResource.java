package com.elisarovani.helpdesk.resources;

import com.elisarovani.helpdesk.domain.Client;
import com.elisarovani.helpdesk.domain.dtos.ClientDTO;
import com.elisarovani.helpdesk.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    // localhost:8080/clients/1
    @Autowired
    private ClientService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Integer id){
        Client obj = this.service.findById(id);
        return ResponseEntity.ok().body(new ClientDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll(){
        List<Client> list = service.findAll();
        List<ClientDTO> listDto = list.stream().map(obj -> new ClientDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create (@Valid @RequestBody ClientDTO objDto){
        Client newObj = service.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Integer id, @Valid @RequestBody ClientDTO objDto){
        Client obj = service.update(id, objDto);
        return ResponseEntity.ok().body(new ClientDTO(obj));
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<ClientDTO> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}
