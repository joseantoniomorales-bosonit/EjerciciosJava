package com.bosonit.block7crudvalidation2.content.professor.domain.repository;

import com.bosonit.block7crudvalidation2.content.professor.domain.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {
}
