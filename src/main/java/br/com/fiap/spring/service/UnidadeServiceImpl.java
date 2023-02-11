package br.com.fiap.spring.service;

import br.com.fiap.spring.dto.CreateUpdateUnidadeDTO;
import br.com.fiap.spring.dto.UnidadeDTO;
import br.com.fiap.spring.entity.UnidadeEntity;
import br.com.fiap.spring.repository.UnidadeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnidadeServiceImpl implements UnidadeService {

    private UnidadeRepository unidadeRepository;

    public UnidadeServiceImpl(UnidadeRepository unidadeRepository){
        this.unidadeRepository = unidadeRepository;
    }

    @Override
    public List<UnidadeDTO> getUnidades() {
        return unidadeRepository.findAll()
                .stream()
                .map(entity -> {
                    UnidadeDTO dto = new UnidadeDTO();
                    dto.setIdUnidade(entity.getIdUnidade());
                    dto.setNomeUnidade(entity.getNomeUnidade());
                    dto.setEnderecoUnidade(entity.getEnderecoUnidade());
                    dto.setTelefoneUnidade(entity.getTelefoneUnidade());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public UnidadeDTO incluirUnidade(CreateUpdateUnidadeDTO createUpdateUnidadeDTO) {
        UnidadeEntity entity = new UnidadeEntity();
        entity.setNomeUnidade(createUpdateUnidadeDTO.getNomeUnidade());
        entity.setEnderecoUnidade(createUpdateUnidadeDTO.getEnderecoUnidade());
        entity.setTelefoneUnidade(createUpdateUnidadeDTO.getTelefoneUnidade());

        UnidadeEntity savedEntity = unidadeRepository.save(entity);

        UnidadeDTO dto = new UnidadeDTO();
        dto.setIdUnidade(savedEntity.getIdUnidade());
        dto.setNomeUnidade(savedEntity.getNomeUnidade());
        dto.setEnderecoUnidade(savedEntity.getEnderecoUnidade());
        dto.setTelefoneUnidade(savedEntity.getTelefoneUnidade());

        return dto;
    }
}

