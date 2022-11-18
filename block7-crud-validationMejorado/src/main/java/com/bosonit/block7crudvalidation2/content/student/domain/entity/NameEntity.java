package com.bosonit.block7crudvalidation2.content.student.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class NameEntity {
    @Id
    @GeneratedValue
    private Integer id;
}
