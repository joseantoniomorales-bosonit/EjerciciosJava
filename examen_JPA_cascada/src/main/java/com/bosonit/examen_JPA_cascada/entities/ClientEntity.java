package com.bosonit.examen_JPA_cascada.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name="Cliente")
@Data
@NoArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="nombre")
    private String name;

    public ClientEntity(String name) {
        this.name = name;
    }
}
