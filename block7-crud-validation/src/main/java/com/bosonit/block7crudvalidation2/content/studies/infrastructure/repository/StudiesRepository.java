package com.bosonit.block7crudvalidation2.content.studies.infrastructure.repository;

import com.bosonit.block7crudvalidation2.content.studies.domain.StudiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudiesRepository extends JpaRepository<StudiesEntity,Integer> {
}
