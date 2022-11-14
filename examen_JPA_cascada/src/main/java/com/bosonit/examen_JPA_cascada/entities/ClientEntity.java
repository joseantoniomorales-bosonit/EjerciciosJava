package com.bosonit.examen_JPA_cascada.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Cliente")
@Data
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="nombre")
    private String name;
}
