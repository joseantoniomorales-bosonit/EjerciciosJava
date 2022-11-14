package com.bosonit.examen_JPA_cascada.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Cabecera_Fra")
@Data
public class InvoiceHeaderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private ClientEntity client;

    @Column(name="ImporteFra")
    private Double amount;
}
