package com.bosonit.block7crudvalidation.repositories;

import com.bosonit.block7crudvalidation.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<PersonaEntity,Integer> {
    List<PersonaEntity> findByUsuario(String usuario);
}
