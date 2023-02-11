package br.com.fiap.spring.controller;

import br.com.fiap.spring.dto.CreateUpdateEspecialidadeDTO;
import br.com.fiap.spring.dto.CreateUpdateUnidadeDTO;
import br.com.fiap.spring.dto.EspecialidadeDTO;
import br.com.fiap.spring.dto.UnidadeDTO;
import br.com.fiap.spring.service.EspecialidadeService;
import br.com.fiap.spring.service.UnidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("especialidades")
public class EspecialidadeController {

    private EspecialidadeService especialidadeService;

    public EspecialidadeController(EspecialidadeService especialidadeService){
        this.especialidadeService = especialidadeService;
    }

    @GetMapping
    public List getEspecialidades(){
        return (List<EspecialidadeDTO>) especialidadeService.getEspecialidades();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EspecialidadeDTO incluirEspecialidade (@RequestBody CreateUpdateEspecialidadeDTO createUpdateEspecialidadeDTO){
        return especialidadeService.incluirEspecialidade(createUpdateEspecialidadeDTO);
    }

}

