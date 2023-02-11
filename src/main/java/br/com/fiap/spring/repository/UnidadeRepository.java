package br.com.fiap.spring.repository;

import br.com.fiap.spring.entity.UnidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UnidadeRepository extends JpaRepository<UnidadeEntity, Integer> {

    @Query(value = "from UnidadeEntity ")
    List<UnidadeEntity> listar();

}
