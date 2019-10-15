package br.com.tr.employee.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tr.employee.model.Rubric;

public interface RubricRepository extends JpaRepository<Rubric, UUID> {

}
