package br.com.fiap.spring.service;

import br.com.fiap.spring.dto.*;

import java.util.List;

public interface EspecialidadeService {

    List<EspecialidadeDTO> getEspecialidades ();
    EspecialidadeDTO incluirEspecialidade(CreateUpdateEspecialidadeDTO createUpdateEspecialidadeDTO);
}
