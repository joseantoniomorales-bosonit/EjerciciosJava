package com.bosonit.block7crudvalidation2.content.student.domain.repository;

import com.bosonit.block7crudvalidation2.content.student.domain.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
}
