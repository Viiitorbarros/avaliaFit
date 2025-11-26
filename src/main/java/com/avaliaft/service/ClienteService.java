package com.avaliaft.service;

import com.avaliaft.models.Avaliacao;
import com.avaliaft.models.Cliente;
import com.avaliaft.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;


    //Cria um novo cliente
    public  Cliente create( Cliente cliente){
        return clienteRepository.save(cliente);
    }

    //Deleta um cliente
    public void delete(Long id){
       Optional<Cliente> clienteDeletado =  clienteRepository.findById(id);
        clienteRepository.delete(clienteDeletado.orElseThrow(()-> new RuntimeException("Cliente Nao encontrado")));

    }

    //Encontra um cliente baseado no ID
    public Cliente findById(Long id){
        return clienteRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Cliente nao econtrado"));

    }

    // Atualiza um cliente
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


    public List<Cliente> findAll (){

        return clienteRepository.findAll();
    }


    public List<Avaliacao> findAvByCLiente(Long id){
        Cliente clienteExistente = findById(id);
        return  clienteExistente.getAvaliacaos();
    }

}
