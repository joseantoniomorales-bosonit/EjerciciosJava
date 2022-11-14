package com.bosonit.examen_JPA_cascada.services;

import com.bosonit.examen_JPA_cascada.dto.ClientDTO;
import com.bosonit.examen_JPA_cascada.entities.ClientEntity;
import com.bosonit.examen_JPA_cascada.repositories.ClientRepository;
import com.bosonit.examen_JPA_cascada.utils.IniDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> findAllClients(){
        return IniDTO.iniClientDTO(clientRepository.findAll());
    }

    public ResponseEntity<Object> findById(int id){
        Optional<ClientEntity> client = clientRepository.findById(id);

        if(client.isPresent()){
            return ResponseEntity.ok().body(IniDTO.iniClientDTO(client.get()));
        }

        return ResponseEntity.status(404).body("Client not found");
    }

    public ClientDTO addClient(ClientEntity client){
        clientRepository.save(client);

        return IniDTO.iniClientDTO(client);
    }

    public ResponseEntity<Object> delClient(int id){
        Optional<ClientEntity> client = clientRepository.findById(id);

        if(client.isPresent()){
            clientRepository.delete(client.get());
            return ResponseEntity.ok().body("Client removed successfully");
        }

        return ResponseEntity.status(404).body("Client not found");
    }
}
