package com.bosonit.block7crudvalidation2.content.person.domain.repository;

import com.bosonit.block7crudvalidation2.content.person.domain.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {
    List<PersonEntity> findByUsername(String username);
}
