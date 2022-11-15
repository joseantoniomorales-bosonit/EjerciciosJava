package com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.output;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PersonOutputDTO implements Serializable {
    private int id_person;

    private String username;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private String img_url;

    private LocalDate created_date;
    private LocalDate termination_date;

}
