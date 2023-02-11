package br.com.fiap.spring.service;

import br.com.fiap.spring.dto.CreateUpdateUnidadeDTO;
import br.com.fiap.spring.dto.UnidadeDTO;

import java.util.List;

public interface UnidadeService {

    List<UnidadeDTO> getUnidades ();
    UnidadeDTO incluirUnidade(CreateUpdateUnidadeDTO createUpdateUnidadeDto);
}
