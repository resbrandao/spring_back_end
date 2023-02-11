package br.com.fiap.spring.repository;

import br.com.fiap.spring.entity.EspecialidadeEntity;
import br.com.fiap.spring.entity.ProfissionalEntity;
import br.com.fiap.spring.entity.UnidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EspecialidadeRepository extends JpaRepository<EspecialidadeEntity, Integer> {
    List<EspecialidadeEntity> findAll();

    @Query(value = "from EspecialidadeEntity")
    List<EspecialidadeEntity> listar();

}
