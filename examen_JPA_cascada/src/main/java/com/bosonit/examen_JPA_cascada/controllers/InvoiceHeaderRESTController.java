package com.bosonit.examen_JPA_cascada.controllers;

import com.bosonit.examen_JPA_cascada.dto.ClientDTO;
import com.bosonit.examen_JPA_cascada.dto.InvoiceHeaderDTO;
import com.bosonit.examen_JPA_cascada.entities.ClientEntity;
import com.bosonit.examen_JPA_cascada.entities.InvoiceHeaderEntity;
import com.bosonit.examen_JPA_cascada.services.InvoiceHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/factura")
public class InvoiceHeaderRESTController {
    @Autowired
    private InvoiceHeaderService invoiceHeaderService;

    @GetMapping("")
    public ResponseEntity<Object> findAllInvoices(){

        return ResponseEntity.ok().body(invoiceHeaderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value="id") Integer id){
        return invoiceHeaderService.findById(id);
    }

    @PostMapping("/create")
    public InvoiceHeaderDTO addInvoiceHeader(@RequestBody InvoiceHeaderEntity invoiceHeader) throws SQLException {
        return invoiceHeaderService.addInvoiceHeader(invoiceHeader);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delInvoiceHeader(@PathVariable(value="id") Integer id) throws SQLException {
        return invoiceHeaderService.delInvoiceHeader(id);
    }
}
