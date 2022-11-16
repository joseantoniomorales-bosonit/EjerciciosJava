package com.bosonit.examen_JPA_cascada.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CabeceraFra")
@Data
@NoArgsConstructor
public class InvoiceHeaderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="client_id")
    private ClientEntity client;

    @Column(name="ImporteFra")
    private Double amount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InvoiceLinesEntity> invoiceLines;

    public InvoiceHeaderEntity(ClientEntity client, Double amount) {
        this.client = client;
        this.amount = amount;
        this.invoiceLines = new ArrayList<>();
    }

    public InvoiceHeaderEntity(ClientEntity client, Double amount, List<InvoiceLinesEntity> invoiceLines) {
        this.client = client;
        this.amount = amount;
        this.invoiceLines = invoiceLines;
    }
}
