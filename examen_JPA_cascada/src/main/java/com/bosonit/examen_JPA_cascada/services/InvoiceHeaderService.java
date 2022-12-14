package com.bosonit.examen_JPA_cascada.services;

import com.bosonit.examen_JPA_cascada.dto.InvoiceHeaderDTO;
import com.bosonit.examen_JPA_cascada.dto.InvoiceLinesDTO;
import com.bosonit.examen_JPA_cascada.entities.ClientEntity;
import com.bosonit.examen_JPA_cascada.entities.InvoiceHeaderEntity;
import com.bosonit.examen_JPA_cascada.repositories.ClientRepository;
import com.bosonit.examen_JPA_cascada.repositories.InvoiceHeaderRepository;
import com.bosonit.examen_JPA_cascada.utils.IniDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceHeaderService {
    @Autowired
    private InvoiceHeaderRepository invoiceHeaderRepository;
    @Autowired
    private ClientRepository clientRepository;

    public List<InvoiceHeaderDTO> findAll(){
        return IniDTO.iniInvoiceHeaderDTO(invoiceHeaderRepository.findAll());
    }

    public Optional<InvoiceHeaderEntity> findByIdEntity(int id){
        return invoiceHeaderRepository.findById(id);
    }

    public ResponseEntity<Object> findById(int id){
        Optional<InvoiceHeaderEntity> invoiceHeader = invoiceHeaderRepository.findById(id);

        if(invoiceHeader.isPresent()){
            return ResponseEntity.ok().body(IniDTO.iniInvoiceHeaderDTO(invoiceHeader.get()));
        }

        return ResponseEntity.status(404).body("Invoice header not found");
    }

    @Transactional(rollbackOn = SQLException.class)
    public InvoiceHeaderDTO addInvoiceHeader(InvoiceHeaderEntity invoiceHeader) throws SQLException {
        try{
        Optional<ClientEntity> client = clientRepository.findById(invoiceHeader.getClient().getId());

        if(client.isPresent()){
            invoiceHeader.setClient(client.get());
            invoiceHeaderRepository.save(invoiceHeader);
        }

        return IniDTO.iniInvoiceHeaderDTO(invoiceHeader);
        }catch (Exception e){
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Transactional(rollbackOn = SQLException.class)
    public ResponseEntity<Object> delInvoiceHeader(int id) throws SQLException {
        try{
            Optional<InvoiceHeaderEntity> invoiceHeader = invoiceHeaderRepository.findById(id);

            if(invoiceHeader.isPresent()){
                invoiceHeaderRepository.delete(invoiceHeader.get());
                return ResponseEntity.ok().body("Invoice header removed successfully");
            }

            return ResponseEntity.status(404).body("Invoice header not found");
        }catch (Exception e){
            e.printStackTrace();
            throw new SQLException();
        }
    }
}
