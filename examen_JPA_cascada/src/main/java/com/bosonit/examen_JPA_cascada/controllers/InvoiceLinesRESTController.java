package com.bosonit.examen_JPA_cascada.controllers;

import com.bosonit.examen_JPA_cascada.entities.InvoiceHeaderEntity;
import com.bosonit.examen_JPA_cascada.entities.InvoiceLinesEntity;
import com.bosonit.examen_JPA_cascada.repositories.InvoiceLinesRepository;
import com.bosonit.examen_JPA_cascada.services.InvoiceHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/factura/linea")
public class InvoiceLinesRESTController {
    @Autowired
    InvoiceLinesRepository invoiceLinesRepository;
    @Autowired
    InvoiceHeaderService invoiceHeaderService;

    @PostMapping("/{idInvoiceHeader}")
    public ResponseEntity<Object> addInvoiceLines(@PathVariable(name="idInvoiceHeader") int idInvoiceHeader, @RequestBody InvoiceLinesEntity invoiceLines){
        InvoiceLinesEntity invoiceLinesParam = invoiceLinesRepository.save(invoiceLines);
        Optional<InvoiceHeaderEntity> invoiceHeaderOptional = invoiceHeaderService.findByIdEntity(idInvoiceHeader);

        if(invoiceHeaderOptional.isEmpty()){
            return ResponseEntity.status(404).body("Id not exists");
        }

        List<InvoiceLinesEntity> invoiceLinesList = invoiceHeaderOptional.get().getInvoiceLines();
        invoiceLinesList.add(invoiceLinesParam);

        invoiceHeaderOptional.get().setInvoiceLines(invoiceLinesList);

        return ResponseEntity.ok().body(invoiceHeaderService.addInvoiceHeader(invoiceHeaderOptional.get()));
    }
}
