package br.com.fiap.spring.controller;

import br.com.fiap.spring.constantes.RabbitMQConstantes;
import br.com.fiap.spring.dto.AgendamentoDTO;
import br.com.fiap.spring.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("agendamento")
public class AgendamentoController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PostMapping
    private ResponseEntity enviaAgendamento(@RequestBody AgendamentoDTO agendamentoDTO) {
        System.out.println(agendamentoDTO.getNomeCliente()  );
        this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_AGENDAMENTO, agendamentoDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

}
