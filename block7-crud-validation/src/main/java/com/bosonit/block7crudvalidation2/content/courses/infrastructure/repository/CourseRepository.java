package com.bosonit.block7crudvalidation2.content.courses.infrastructure.repository;

import com.bosonit.block7crudvalidation2.content.courses.domain.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
}
