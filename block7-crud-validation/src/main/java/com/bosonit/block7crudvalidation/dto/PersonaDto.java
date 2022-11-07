package com.bosonit.block7crudvalidation.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PersonaDto implements Serializable {
    private int id_persona;

    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private String imagen_url;

    private boolean active;

    private LocalDate created_date;
    private LocalDate termination_date;


}
