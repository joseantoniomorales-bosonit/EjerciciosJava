package com.bosonit.block7crudvalidation2.content.student.infrastructure.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentFullOutputDTO {
    private Integer id;
    private Integer num_hours_week;

    private String comments;
    private String branch;

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
