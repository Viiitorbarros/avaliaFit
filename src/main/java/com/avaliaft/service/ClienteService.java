package com.avaliaft.service;

import com.avaliaft.models.Cliente;
import com.avaliaft.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;



    public  Cliente create( Cliente cliente){
        return clienteRepository.save(cliente);
    }


    public void delete(Long id){
       Optional<Cliente> clienteDeletado =  clienteRepository.findById(id);
        clienteRepository.delete(clienteDeletado.orElseThrow(()-> new RuntimeException("Cliente Nao encontrado")));

    }

    public Cliente findById(Long id){
        return clienteRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Cliente nao econtrado"));

    }

    public Cliente update (Cliente clienteNovosDados, long id){
        Cliente clienteExistente = findById(id);
        if(clienteNovosDados.getNome() != null) {
            clienteExistente.setNome(clienteNovosDados.getNome());
        }
        if(clienteNovosDados.getIdade() != null) {
            clienteExistente.setIdade(clienteNovosDados.getIdade());
        }
        if(clienteNovosDados.getSexo() != null) {
            clienteExistente.setSexo(clienteNovosDados.getSexo());
        }
        if(clienteNovosDados.getTelefone() != null) {
            clienteExistente.setTelefone(clienteNovosDados.getTelefone());
        }

        return clienteRepository.save(clienteExistente);

    }

    public  Cliente findByNome(String nome){
        return  clienteRepository.findByNome(nome).orElseThrow(()-> new RuntimeException("Nome não encontrado"));
    }

}
