package com.bosonit.block7crudvalidation2.content.student.domain.repository;

import com.bosonit.PlantillaArquitecturaExagonal.content.entityName.domain.entity.NameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<NameEntity,Integer> {
}
