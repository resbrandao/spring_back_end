package br.com.fiap.spring.service;

import br.com.fiap.spring.dto.CreateUpdateEspecialidadeDTO;
import br.com.fiap.spring.dto.CreateUpdateProfissionalDTO;
import br.com.fiap.spring.dto.EspecialidadeDTO;
import br.com.fiap.spring.dto.ProfissionalDTO;
import br.com.fiap.spring.entity.EspecialidadeEntity;
import br.com.fiap.spring.entity.ProfissionalEntity;
import br.com.fiap.spring.repository.EspecialidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecialidadeServiceImpl implements EspecialidadeService{
    private EspecialidadeRepository especialidadeRepository;

    public EspecialidadeServiceImpl(EspecialidadeRepository especialidadeRepository){
        this.especialidadeRepository = especialidadeRepository;
    }
    public List<EspecialidadeDTO> getEspecialidades() {
        return especialidadeRepository.findAll()
                .stream()
                .map(entity -> {
                    EspecialidadeDTO dto = new EspecialidadeDTO();
                    dto.setIdEspecialidade(entity.getIdEspecialidade());
                    dto.setNomeEspecialidade(entity.getNomeEspecialidade());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public EspecialidadeDTO incluirEspecialidade(CreateUpdateEspecialidadeDTO createUpdateEspecialidadeDTO) {
        EspecialidadeEntity entity = new EspecialidadeEntity();
        entity.setNomeEspecialidade(createUpdateEspecialidadeDTO.getNomeEspecialidade());

        EspecialidadeEntity savedEntity = especialidadeRepository.save(entity);

        EspecialidadeDTO dto = new EspecialidadeDTO();
        dto.setIdEspecialidade(savedEntity.getIdEspecialidade());
        dto.setNomeEspecialidade(savedEntity.getNomeEspecialidade());

        return dto;
    }
}
