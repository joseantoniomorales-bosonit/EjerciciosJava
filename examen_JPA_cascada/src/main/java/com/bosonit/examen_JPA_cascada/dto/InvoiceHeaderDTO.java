package com.bosonit.examen_JPA_cascada.dto;

import lombok.Data;

import java.util.List;

@Data
public class InvoiceHeaderDTO {
    private int id;

    private Double importeFra=0.0;

    private ClientDTO clientDTO;
    private List<InvoiceLinesDTO> invoiceLinesDTOList;
}
