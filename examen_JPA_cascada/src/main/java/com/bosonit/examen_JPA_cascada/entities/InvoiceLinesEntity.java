package com.bosonit.examen_JPA_cascada.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="LineasFra")
@Data
@NoArgsConstructor
public class InvoiceLinesEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(name="ProNomb")
    private String ProName;

    @Column(name="Cantidad")
    private Double amount;
    @Column(name="precio")
    private Double price;

    public InvoiceLinesEntity(String proName, Double amount, Double price) {
        this.ProName = proName;
        this.amount = amount;
        this.price = price;
    }
}
