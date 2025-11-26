package com.avaliaft.service;


import com.avaliaft.models.Avaliacao;
import com.avaliaft.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    ClienteService clienteService;

    public Avaliacao findById(Long id){

       return avaliacaoRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("\"Avaliação não encontrada com id: \" + id"));


    }

    //Criar avaliacao
    public Avaliacao create(Avaliacao avaliacao){
        return avaliacaoRepository.save(avaliacao);
    }


    //Deletar avaliacao
    public void delete(Long id){

      Optional<Avaliacao> avaliacaoExistente = avaliacaoRepository.findById(id);
      avaliacaoRepository.delete(avaliacaoExistente.orElseThrow(()->new RuntimeException("Avaliação nao encontrada.")));

    }










}
