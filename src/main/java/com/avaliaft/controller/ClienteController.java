package com.avaliaft.controller;


import com.avaliaft.models.Cliente;
import com.avaliaft.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/cliente")
    public Cliente crate (@RequestBody Cliente cliente){
        return clienteService.create(cliente);
    }

    @GetMapping("/{nome}")
    public Cliente findByNome (@PathVariable String nome ){
        return  clienteService.findByNome(nome);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        clienteService.delete(id);
    }

}
