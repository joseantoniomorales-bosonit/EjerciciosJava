package com.bosonit.block7crudvalidation2.content.person.infrastructure.dto.output;

import com.bosonit.block7crudvalidation2.content.person.domain.PersonEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
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

    public PersonOutputDTO (PersonEntity person){
        this.id_person = person.getId_person();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.company_email = person.getCompany_email();
        this. personal_email = person.getPersonal_email();
        this.city = person.getCity();
        this.img_url = person.getImg_url();
        this.created_date = person.getCreated_date();
        this.termination_date = person.getTermination_date();
    }
}
