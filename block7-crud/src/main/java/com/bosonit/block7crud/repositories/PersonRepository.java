package com.bosonit.block7crud.repositories;

import com.bosonit.block7crud.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {
    //@Query("SELECT * FROM person WHERE name = ?")
    List<PersonEntity> findByName(String name);
}
