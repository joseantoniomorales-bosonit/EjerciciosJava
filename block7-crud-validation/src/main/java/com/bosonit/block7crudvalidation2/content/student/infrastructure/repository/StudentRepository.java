package com.bosonit.block7crudvalidation2.content.student.infrastructure.repository;

import com.bosonit.block7crudvalidation2.content.courses.domain.CourseEntity;
import com.bosonit.block7crudvalidation2.content.student.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
    @Query(value = "select count(*) from profesores where id_persona=?1", nativeQuery = true)
    int countWithIdPerson(int id);

    @Query(value="select * from estudiantes where id_persona=?1", nativeQuery = true)
    Optional<StudentEntity> findByIdPerson(int idPerson);


}
