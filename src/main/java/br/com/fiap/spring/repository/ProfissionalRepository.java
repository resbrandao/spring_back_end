package br.com.fiap.spring.repository;

import br.com.fiap.spring.entity.ProfissionalEntity;
import br.com.fiap.spring.entity.UnidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfissionalRepository extends JpaRepository<ProfissionalEntity, Integer> {
    List<ProfissionalEntity> findAll();

    @Query(value = "from ProfissionalEntity")
    List<ProfissionalEntity> listar();

}
