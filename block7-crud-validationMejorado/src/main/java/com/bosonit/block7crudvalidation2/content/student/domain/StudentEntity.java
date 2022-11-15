package com.bosonit.block7crudvalidation2.content.student.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persona")
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_persona;

    @Column(name="usuario")
    private String usuario;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="company_email")
    private String company_email;
    @Column(name="personal_email")
    private String personal_email;
    @Column(name="city")
    private String city;
    @Column(name="imagen_url")
    private String imagen_url;

    @Column(name="active")
    private boolean active;

    @Column(name="created_date")
    private LocalDate created_date;
    @Column(name="termination_date")
    private LocalDate termination_date;
}
