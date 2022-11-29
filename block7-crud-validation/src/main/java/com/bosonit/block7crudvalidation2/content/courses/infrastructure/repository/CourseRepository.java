package com.bosonit.block7crudvalidation2.content.courses.infrastructure.repository;

import com.bosonit.block7crudvalidation2.content.courses.domain.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
    @Query(value="select * from asignaturas join estudiantes_course on estudiantes_course.course_id = asignaturas.id" +
            " where estudiantes_course.student_entity_id = ?1", nativeQuery = true)
    List<CourseEntity> findCoursesById(int idStudent);
}
