package com.bosonit.examen_JPA_cascada.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="CabeceraFra")
@Data
public class InvoiceHeaderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private ClientEntity client;

    @Column(name="ImporteFra")
    private Double amount;
}
