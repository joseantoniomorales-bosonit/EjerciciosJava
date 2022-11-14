package com.bosonit.examen_JPA_cascada.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="LineasFra")
@Data
public class InvoiceLinesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="IdFra")
    private InvoiceHeaderEntity invoiceHeader;

    @NotNull
    @Column(name="ProNomb")
    private String ProName;

    @Column(name="Cantidad")
    private Double amount;
    @Column(name="precio")
    private Double price;
}
