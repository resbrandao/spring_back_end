package br.com.fiap.spring.service;

import br.com.fiap.spring.dto.CreateUpdateProfissionalDTO;
import br.com.fiap.spring.dto.CreateUpdateUnidadeDTO;
import br.com.fiap.spring.dto.ProfissionalDTO;
import br.com.fiap.spring.dto.UnidadeDTO;
import br.com.fiap.spring.entity.ProfissionalEntity;
import br.com.fiap.spring.entity.UnidadeEntity;
import br.com.fiap.spring.repository.ProfissionalRepository;
import br.com.fiap.spring.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfissionalServiceImpl implements ProfissionalService {

    private ProfissionalRepository profissionalRepository;

    public ProfissionalServiceImpl(ProfissionalRepository profissionalRepository){
        this.profissionalRepository = profissionalRepository;
    }

    public List<ProfissionalDTO> getProfissionais() {
        return profissionalRepository.findAll()
                .stream()
                .map(entity -> {
                    ProfissionalDTO dto = new ProfissionalDTO();
                    dto.setIdProfissional(entity.getIdProfissional());
                    dto.setNomeProfissional(entity.getNomeProfissional());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public ProfissionalDTO incluirProfissional(CreateUpdateProfissionalDTO createUpdateProfissionalDTO) {
        ProfissionalEntity entity = new ProfissionalEntity();
        entity.setNomeProfissional(createUpdateProfissionalDTO.getNomeProfissional());

        ProfissionalEntity savedEntity = profissionalRepository.save(entity);

        ProfissionalDTO dto = new ProfissionalDTO();
        dto.setIdProfissional(savedEntity.getIdProfissional());
        dto.setNomeProfissional(savedEntity.getNomeProfissional());

        return dto;
    }
}

