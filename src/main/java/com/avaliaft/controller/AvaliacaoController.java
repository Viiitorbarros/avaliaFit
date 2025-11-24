package com.avaliaft.controller;

import com.avaliaft.models.Avaliacao;
import com.avaliaft.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{avaliacaos}")
public class AvaliacaoController {

    @Autowired
    AvaliacaoService avaliacaoService;
    
    @PostMapping("/{avaliacao}")
    public Avaliacao create(@RequestBody Avaliacao avaliacao){
        Avaliacao novaAvaliacao = avaliacaoService.create(avaliacao);
        return novaAvaliacao;
    }



}
