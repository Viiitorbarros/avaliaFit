package com.avaliaft.controller;

import com.avaliaft.models.Avaliacao;
import com.avaliaft.service.AvaliacaoService;
import com.avaliaft.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    AvaliacaoService avaliacaoService;

    @Autowired
    ClienteService clienteService;
    
    @PostMapping()
    public Avaliacao create(@RequestBody Avaliacao avaliacao){
        Avaliacao novaAvaliacao = avaliacaoService.create(avaliacao);
        return novaAvaliacao;
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        avaliacaoService.delete(id);
    }

    //UPDATE
    @PutMapping("/{id}")
    public Avaliacao update(@RequestBody Avaliacao avaliacaoAtualizada, @PathVariable Long id){
        return avaliacaoService.update(avaliacaoAtualizada, id);
    }

    //BUSCAR POR ID
    @GetMapping("/{id}")
    public Avaliacao findByID(@PathVariable Long id){
       return avaliacaoService.findById(id);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Avaliacao> listarPorCliente(@PathVariable Long clienteId) {
        // Você não precisa criar lógica nova, apenas chama o que já está pronto
        return clienteService.findAvByCLiente(clienteId);
    }
}
