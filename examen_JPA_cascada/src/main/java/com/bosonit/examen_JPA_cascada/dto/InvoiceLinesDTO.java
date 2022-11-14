package com.bosonit.examen_JPA_cascada.dto;

import lombok.Data;

@Data
public class InvoiceLinesDTO {
    private int id;

    private String producto;

    private double cantidad;
    private double importe;
}
