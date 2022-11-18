package com.bosonit.block7crudvalidation2.content.studies.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class StudiesEntity {
    @Id
    @GeneratedValue
    private Integer id;
}
