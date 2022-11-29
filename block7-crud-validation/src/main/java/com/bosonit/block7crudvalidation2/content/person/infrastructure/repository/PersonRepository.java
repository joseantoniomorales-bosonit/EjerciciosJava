package com.bosonit.block7crudvalidation2.content.person.infrastructure.repository;

import com.bosonit.block7crudvalidation2.content.person.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {

    List<PersonEntity> findByUsername(String username);

    @Query(value = "select " +
            "new persona.id_person as id_person, usuario as username, name as name, surname as surname, company_email as company_email, personal_email as personal_email," +
            "city as city, imagen_url as img_url, created_date as created_date, termination_date as termination_date, id_profesor as id_profesor," +
            "comments as comments, branch as branch " +
            "from persona " +
            "join profesores on profesores.id_persona = persona.id_person " +
            "where persona.id_person = ?1", nativeQuery = true)
    Map<String,String> findByIdAndProfessor(int id);

    @Query(value="select count(*) from profesores where id_persona=?1", nativeQuery = true)
    int isProfessor(int id);

    @Query(value = "select count(*) from estudiantes where id_persona=?1", nativeQuery = true)
    int isStudent(int id);

    @Query(value="select " +
            "sum((select count(*) from estudiantes where id_persona = ?1)+" +
            "(select count(*) from profesores where id_persona = ?1))" +
            "from persona " +
            "where id_person = ?1", nativeQuery = true)
    int isDelete(int id);
}
