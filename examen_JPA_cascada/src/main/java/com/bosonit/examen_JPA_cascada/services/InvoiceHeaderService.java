package com.bosonit.examen_JPA_cascada.services;

import com.bosonit.examen_JPA_cascada.dto.InvoiceHeaderDTO;
import com.bosonit.examen_JPA_cascada.dto.InvoiceLinesDTO;
import com.bosonit.examen_JPA_cascada.entities.ClientEntity;
import com.bosonit.examen_JPA_cascada.entities.InvoiceHeaderEntity;
import com.bosonit.examen_JPA_cascada.repositories.InvoiceHeaderRepository;
import com.bosonit.examen_JPA_cascada.utils.IniDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceHeaderService {
    @Autowired
    private InvoiceHeaderRepository invoiceHeaderRepository;

    public List<InvoiceHeaderDTO> findAll(){
        return IniDTO.iniInvoiceHeaderDTO(invoiceHeaderRepository.findAll());
    }

    public ResponseEntity<Object> findById(int id){
        Optional<InvoiceHeaderEntity> invoiceHeader = invoiceHeaderRepository.findById(id);

        if(invoiceHeader.isPresent()){
            return ResponseEntity.ok().body(IniDTO.iniInvoiceHeaderDTO(invoiceHeader.get()));
        }

        return ResponseEntity.status(404).body("Invoice header not found");
    }

    public InvoiceHeaderDTO addInvoiceHeader(InvoiceHeaderEntity invoiceHeader){
        invoiceHeaderRepository.save(invoiceHeader);

        return IniDTO.iniInvoiceHeaderDTO(invoiceHeader);
    }

    public void addInvoiceHeader2(InvoiceHeaderEntity invoiceHeader){
        System.out.println(invoiceHeader);
    }

    public ResponseEntity<Object> delInvoiceHeader(int id){
        Optional<InvoiceHeaderEntity> invoiceHeader = invoiceHeaderRepository.findById(id);

        if(invoiceHeader.isPresent()){
            invoiceHeaderRepository.delete(invoiceHeader.get());
            return ResponseEntity.ok().body("Invoice header removed successfully");
        }

        return ResponseEntity.status(404).body("Invoice header not found");
    }
}
