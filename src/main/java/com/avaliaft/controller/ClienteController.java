package com.avaliaft.controller;


import com.avaliaft.models.Cliente;
import com.avaliaft.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/cliente")
    public Cliente crate (@RequestBody Cliente cliente){
        return clienteService.create(cliente);
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id ){
        return  clienteService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        clienteService.delete(id);
    }

    @PutMapping("/{id}")
    public Cliente update(@RequestBody Cliente clienteAtualizado, @PathVariable Long id){
       return clienteService.update(clienteAtualizado,id);
    }

    @GetMapping
    public List<Cliente> findAll (){
         return clienteService.findAll();
    }



}
