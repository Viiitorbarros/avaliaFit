package com.avaliaft.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.avaliaft.models.Agendamento;
import com.avaliaft.service.AgendamentoService;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public List<Agendamento> findAll() {
        return agendamentoService.findAll();
    }

    @GetMapping("/{id}")
    public Agendamento findById(@PathVariable Long id) {
        return  agendamentoService.findById(id);
    }

    @PostMapping
    public Agendamento createAgendamento(@RequestBody Agendamento agendamento){
        return agendamentoService.save(agendamento);
    }

    @PutMapping("/{id}")
    public Agendamento updateAgendamento (@PathVariable long id,@RequestBody Agendamento agendamento){
        return agendamentoService.update(id ,agendamento);
    }

    @DeleteMapping("/{id}")
    public void deleteAgendamento(@PathVariable long id){
        agendamentoService.delete(id);
    }
}