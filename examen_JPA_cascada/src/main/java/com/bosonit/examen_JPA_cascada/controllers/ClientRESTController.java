package com.bosonit.examen_JPA_cascada.controllers;

import com.bosonit.examen_JPA_cascada.dto.ClientDTO;
import com.bosonit.examen_JPA_cascada.entities.ClientEntity;
import com.bosonit.examen_JPA_cascada.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClientRESTController {
    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public List<ClientDTO> findAllClients(){
        return clientService.findAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value="id") Integer id){
        return clientService.findById(id);
    }

    @PostMapping("/create")
    public ClientDTO addClient(@RequestBody ClientEntity client){
        return clientService.addClient(client);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delClient(@PathVariable(value="id") Integer id){
        return clientService.delClient(id);
    }
}
