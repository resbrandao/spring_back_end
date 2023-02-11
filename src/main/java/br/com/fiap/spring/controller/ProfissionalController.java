package br.com.fiap.spring.controller;

import br.com.fiap.spring.dto.CreateUpdateProfissionalDTO;
import br.com.fiap.spring.dto.CreateUpdateUnidadeDTO;
import br.com.fiap.spring.dto.ProfissionalDTO;
import br.com.fiap.spring.dto.UnidadeDTO;
import br.com.fiap.spring.service.ProfissionalService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profissionais")
public class ProfissionalController {
    private ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService){
        this.profissionalService = profissionalService;
    }

    @GetMapping
    public List getProfissionais(){
        return (List<ProfissionalDTO>) profissionalService.getProfissionais();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfissionalDTO incluirProfissional (@RequestBody CreateUpdateProfissionalDTO createUpdateProfissionalDTO){
        return profissionalService.incluirProfissional(createUpdateProfissionalDTO);
    }

}
