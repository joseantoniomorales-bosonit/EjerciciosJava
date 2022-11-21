package com.bosonit.block7crudvalidation2.content.person.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persona")
@Data
@NoArgsConstructor
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

    public PersonEntity(String username, String password, String name, String surname, String company_email, String personal_email, String city) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.company_email = company_email;
        this.personal_email = personal_email;
        this.city = city;
        this.created_date =  LocalDate.now();
        this.active = true;
    }
}
