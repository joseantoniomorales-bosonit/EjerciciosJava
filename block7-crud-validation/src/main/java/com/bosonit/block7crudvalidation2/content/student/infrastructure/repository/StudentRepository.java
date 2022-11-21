package com.bosonit.block7crudvalidation2.content.student.infrastructure.repository;

import com.bosonit.block7crudvalidation2.content.student.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
}
