package br.com.fiap.spring.controller;

import br.com.fiap.spring.dto.CreateUpdateUnidadeDTO;
import br.com.fiap.spring.dto.UnidadeDTO;
import br.com.fiap.spring.service.UnidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("unidades")
public class UnidadeController {

    private UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService){
        this.unidadeService = unidadeService;
    }

    @GetMapping
    public List getUnidades(){

        return (List<UnidadeDTO>) unidadeService.getUnidades();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UnidadeDTO incluirUnidade (@RequestBody CreateUpdateUnidadeDTO createUpdateUnidadeDTO){
        return unidadeService.incluirUnidade(createUpdateUnidadeDTO);
    }

}

