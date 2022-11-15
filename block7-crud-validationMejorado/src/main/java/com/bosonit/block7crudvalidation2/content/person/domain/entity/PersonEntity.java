package com.bosonit.block7crudvalidation2.content.person.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persona")
@Data
public class PersonEntity {
    @Id
    @GeneratedValue
    private Integer id_person;

    @Column(name="usuario")
    private String username;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String company_email;
    @Column
    private String personal_email;
    @Column
    private String city;
    @Column(name="imagen_url")
    private String img_url;

    @Column
    private boolean active;

    @Column
    private LocalDate created_date;
    @Column
    private LocalDate termination_date;
}
