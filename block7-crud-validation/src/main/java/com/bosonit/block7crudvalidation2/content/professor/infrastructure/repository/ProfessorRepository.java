package com.bosonit.block7crudvalidation2.content.professor.infrastructure.repository;

import com.bosonit.block7crudvalidation2.content.professor.domain.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {
    @Query(value = "select * from profesores where id_persona=?1", nativeQuery = true)
    Optional<ProfessorEntity> findByIdPerson(int id_persona);
}
