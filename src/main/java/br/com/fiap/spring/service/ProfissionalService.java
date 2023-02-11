package br.com.fiap.spring.service;

import br.com.fiap.spring.dto.CreateUpdateProfissionalDTO;
import br.com.fiap.spring.dto.CreateUpdateUnidadeDTO;
import br.com.fiap.spring.dto.ProfissionalDTO;
import br.com.fiap.spring.dto.UnidadeDTO;

import java.util.List;

public interface ProfissionalService {

    List<ProfissionalDTO> getProfissionais ();
    ProfissionalDTO incluirProfissional(CreateUpdateProfissionalDTO createUpdateProfissionalDTO);
}
