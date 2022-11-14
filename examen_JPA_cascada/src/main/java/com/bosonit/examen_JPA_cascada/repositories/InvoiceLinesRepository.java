package com.bosonit.examen_JPA_cascada.repositories;

import com.bosonit.examen_JPA_cascada.entities.InvoiceLinesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceLinesRepository extends JpaRepository<InvoiceLinesEntity,Integer> {
}
