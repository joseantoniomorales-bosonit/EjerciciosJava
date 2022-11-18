package com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.input;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PersonInputDTO implements Serializable {
    private Integer id_person;

    private String username;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private String img_url;

    private boolean active;

    private LocalDate created_date;
    private LocalDate termination_date;
}
